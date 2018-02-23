namespace java cn.jikexueyuan.ubas.service

service UBASService {
	map<string, double> queryDayKPI(1:string beginDate,2:string endDate),
	map<double, double> queryHourKPI(1:string beginDate,2:string endDate)
}