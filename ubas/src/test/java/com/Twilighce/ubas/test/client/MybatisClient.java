package com.Twilighce.ubas.test.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Twilighce.ubas.dao.KpiDao;
import com.Twilighce.ubas.domain.ReportParam;
import com.Twilighce.ubas.util.MySQLFactory;


public class MybatisClient {

	private static Logger LOGGER = LoggerFactory.getLogger(MybatisClient.class);

	public static void main(String[] args) {
		try {
			ReportParam param = new ReportParam();
			param.setBeginDate("2018-1-25");
			param.setEndDate("2018-1-26");
			LOGGER.info("get ubas day:" + ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getSummary(param));
			LOGGER.info("get amount hour:" + ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param));
			List<Map<Double, Double>> list = ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param);
			System.out.println(list.toString());
			Map<Double, Double> map2 = new HashMap<Double, Double>();
			for (Map<Double, Double> map : list) {
				map2.put(map.get("kpi_code"), map.get("kpi_value"));
			}
			System.out.println(map2.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
