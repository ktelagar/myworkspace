package com.async.client;

import java.util.concurrent.ExecutionException;

public class SalesReportTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SalesReport salesReport = new SalesReport();
		Report report = salesReport.generateAnnualReport(2022);
		System.out.println(report);
	}
}
