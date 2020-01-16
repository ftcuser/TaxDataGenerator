package com.citizant.irs.taxdatagenerator.model;

public class Refund {
	
	private long overpaid_20 = 0;
	private long refundAmount_21a = 0;
	private String routeNumber_21b = "";
	private String accountNumber_21d = "";
	private String acountType = "Checking";
	private long amounToNextYear_22 = 0;
	public long getOverpaid_20() {
		return overpaid_20;
	}
	public void setOverpaid_20(long overpaid_20) {
		this.overpaid_20 = overpaid_20;
	}
	public long getRefundAmount_21a() {
		return refundAmount_21a;
	}
	public void setRefundAmount_21a(long refundAmount_21a) {
		this.refundAmount_21a = refundAmount_21a;
	}
	public String getRouteNumber_21b() {
		return routeNumber_21b;
	}
	public void setRouteNumber_21b(String routeNumber_21b) {
		this.routeNumber_21b = routeNumber_21b;
	}
	public String getAccountNumber_21d() {
		return accountNumber_21d;
	}
	public void setAccountNumber_21d(String accountNumber_21d) {
		this.accountNumber_21d = accountNumber_21d;
	}
	public String getAcountType() {
		return acountType;
	}
	public void setAcountType(String acountType) {
		this.acountType = acountType;
	}
	public long getAmounToNextYear_22() {
		return amounToNextYear_22;
	}
	public void setAmounToNextYear_22(long amounToNextYear_22) {
		this.amounToNextYear_22 = amounToNextYear_22;
	}

}
