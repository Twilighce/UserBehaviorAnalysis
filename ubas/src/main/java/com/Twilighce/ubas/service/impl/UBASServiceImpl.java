package com.Twilighce.ubas.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import com.Twilighce.ubas.dao.KpiDao;
import com.Twilighce.ubas.domain.ReportParam;
import com.Twilighce.ubas.service.UBASService;
import com.Twilighce.ubas.util.MySQLFactory;


public class UBASServiceImpl implements UBASService.Iface {

	@Override
	public Map<String, Double> queryDayKPI(String beginDate, String endDate) throws TException {
		ReportParam param = new ReportParam();
		param.setBeginDate(beginDate);
		param.setEndDate(endDate);
		return ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getSummary(param);
	}

	@Override
	public Map<Double, Double> queryHourKPI(String beginDate, String endDate) throws TException {
		ReportParam param = new ReportParam();
		param.setBeginDate(beginDate);
		param.setEndDate(endDate);

		Map<Double, Double> map = new HashMap<Double, Double>();
		List<Map<Double, Double>> list = ((KpiDao) MySQLFactory.createMapper(KpiDao.class)).getAmount(param);
		for (Map<Double, Double> map2 : list) {
			map.put(map2.get("kpi_code"), map2.get("kpi_value"));
		}
		return map;
	}

}
