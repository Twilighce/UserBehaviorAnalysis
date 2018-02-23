#! /bin/bash

# args length must be 1
if [ $# != 1 ] ; then  
echo "USAGE: args length must be 1"  
exit 1;  
fi 

# clean hdfs data and output 
# 对数据做初步的清洗
/home/hadoop/hadoop-2.6.0/bin/hadoop jar ubas-1.0.0-jar-with-dependencies.jar $1

# use hive to stats
# 将初步清洗后的数据加载到表当真
## 1.location data to partition
/home/hadoop/hive-0.14.0-bin/bin/hive -e "ALTER TABLE ubas ADD PARTITION(logdate='$1') LOCATION '/home/hdfs/ubas/out/meta/$1';"

## 2.stats pv
/home/hadoop/hive-0.14.0-bin/bin/hive -e "CREATE TABLE pv_$1 AS SELECT COUNT(1) AS PV FROM ubas WHERE logdate='$1';"

## 3.stats ip
/home/hadoop/hive-0.14.0-bin/bin/hive -e "CREATE TABLE ip_$1 AS SELECT COUNT(DISTINCT ip) AS IP FROM ubas WHERE logdate='$1';"

## 4.stats amount hour
/home/hadoop/hive-0.14.0-bin/bin/hive -e "CREATE TABLE amount_$1 ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' AS SELECT '$1',hour AS HOUR_TAG, COUNT(hour) AS HOUR,'' AS UPDATE_DATE FROM ubas WHERE logdate='$1' GROUP BY hour;"

## 5.stats jr
/home/hadoop/hive-0.14.0-bin/bin/hive -e "CREATE TABLE jr_$1 AS SELECT COUNT(1) AS JR FROM (SELECT COUNT(ip) AS times FROM ubas WHERE logdate='$1' GROUP BY ip HAVING times=1) e;"

## 6.combine pv,ip,jr and tr to ubas table
/home/hadoop/hive-0.14.0-bin/bin/hive -e "CREATE TABLE ubas_$1 ROW FORMAT DELIMITED FIELDS TERMINATED BY ',' AS SELECT '$1', a.pv, b.ip, c.jr, ROUND(COALESCE(CAST(b.ip AS DOUBLE), 0)/a.pv, 2),'' AS UPDATE_DATE FROM pv_$1 a JOIN ip_$1 b ON 1=1 JOIN jr_$1 c ON 1=1 ;"

# sqoop data to mysql

## 1.sqoop t_kpi_day
/home/hadoop/sqoop-1.4.5/bin/sqoop export -D sqoop.export.records.per.statement=100 --connect jdbc:mysql://10.211.55.26:3306/hadoop_ubas --username root --password root --table t_kpi_day --fields-terminated-by ',' --export-dir "/home/hive/warehouse/ubas_$1" --batch --update-key createdate --update-mode allowinsert;

## 2.sqoop t_kpi_hour
/home/hadoop/sqoop-1.4.5/bin/sqoop export -D sqoop.export.records.per.statement=100 --connect jdbc:mysql://10.211.55.26:3306/hadoop_ubas --username root --password root --table t_kpi_hour --fields-terminated-by ',' --export-dir "/home/hive/warehouse/amount_$1" --batch --update-key createdate,kpi_code --update-mode allowinsert;

# drop tmp table to hive warehouse
/home/hadoop/hive-0.14.0-bin/bin/hive -e "drop table amount_$1;drop table ip_$1;drop table jr_$1;drop table pv_$1;drop table ubas_$1;"
