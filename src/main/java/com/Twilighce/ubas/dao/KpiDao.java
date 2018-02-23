package com.Twilighce.ubas.dao;

import java.util.List;
import java.util.Map;

import com.Twilighce.ubas.domain.ReportParam;
import com.Twilighce.ubas.service.Mapper;


public interface KpiDao extends Mapper {
	/**
	 * get amount data list
	 * 
	 * @param param
	 * @return Object list
	 */
	public List<Map<Double, Double>> getAmount(ReportParam param);

	/**
	 * get ubas summary data list
	 * 
	 * @param param
	 * @return more result
	 */
	public Map<String, Double> getSummary(ReportParam param);

}
