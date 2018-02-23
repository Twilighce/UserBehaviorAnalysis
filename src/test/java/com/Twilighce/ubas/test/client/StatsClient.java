package com.Twilighce.ubas.test.client;

import java.util.Map;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.Twilighce.ubas.service.UBASService;


public class StatsClient {

	public static final String ADDRESS = "10.211.55.18";
	public static final int PORT = 9090;
	public static final int TIMEOUT = 30000;

	public static void main(String[] args) {
		TTransport transport = new TFramedTransport(new TSocket(ADDRESS, PORT, TIMEOUT));
		TProtocol protocol = new TCompactProtocol(transport);
		UBASService.Client client = new UBASService.Client(protocol);
		String beginDate = "20180125";
		String endDate = "20180126";

		try {
			transport.open();
			Map<String, Double> dayKpi = client.queryDayKPI(beginDate, endDate);
			System.out.println("dayKpi:" + dayKpi.toString());

			Map<Double, Double> hourKpi = client.queryHourKPI(beginDate, endDate);
			System.out.println("hourKpi:" + hourKpi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}
	}

}
