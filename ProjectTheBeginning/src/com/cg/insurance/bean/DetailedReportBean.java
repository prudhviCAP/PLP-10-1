package com.cg.insurance.bean;

public class DetailedReportBean {

	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private int insuredZip;
	private String BusinessSegment;
	private String quesDesc1;
	private String quesDesc2;
	private String quesDesc3;
	private String quesDesc4;
	private String quesDesc5;
	private String coverage1;
	private String coverage2;
	private String coverage3;
	private double premiumAmount;
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredStreet() {
		return insuredStreet;
	}
	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}
	public String getInsuredCity() {
		return insuredCity;
	}
	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}
	public String getInsuredState() {
		return insuredState;
	}
	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}
	public int getInsuredZip() {
		return insuredZip;
	}
	public void setInsuredZip(int insuredZip) {
		this.insuredZip = insuredZip;
	}
	public String getBusinessSegment() {
		return BusinessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		BusinessSegment = businessSegment;
	}
	public String getQuesDesc1() {
		return quesDesc1;
	}
	public void setQuesDesc1(String quesDesc1) {
		this.quesDesc1 = quesDesc1;
	}
	public String getQuesDesc2() {
		return quesDesc2;
	}
	public void setQuesDesc2(String quesDesc2) {
		this.quesDesc2 = quesDesc2;
	}
	public String getQuesDesc3() {
		return quesDesc3;
	}
	public void setQuesDesc3(String quesDesc3) {
		this.quesDesc3 = quesDesc3;
	}
	public String getQuesDesc4() {
		return quesDesc4;
	}
	public void setQuesDesc4(String quesDesc4) {
		this.quesDesc4 = quesDesc4;
	}
	public String getQuesDesc5() {
		return quesDesc5;
	}
	public void setQuesDesc5(String quesDesc5) {
		this.quesDesc5 = quesDesc5;
	}
	public String getCoverage1() {
		return coverage1;
	}
	public void setCoverage1(String coverage1) {
		this.coverage1 = coverage1;
	}
	public String getCoverage2() {
		return coverage2;
	}
	public void setCoverage2(String coverage2) {
		this.coverage2 = coverage2;
	}
	public String getCoverage3() {
		return coverage3;
	}
	public void setCoverage3(String coverage3) {
		this.coverage3 = coverage3;
	}
	public double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	@Override
	public String toString() {
		return "DetailedReportBean [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", BusinessSegment="
				+ BusinessSegment + ", quesDesc1=" + quesDesc1 + ", quesDesc2=" + quesDesc2 + ", quesDesc3=" + quesDesc3
				+ ", quesDesc4=" + quesDesc4 + ", quesDesc5=" + quesDesc5 + ", coverage1=" + coverage1 + ", coverage2="
				+ coverage2 + ", coverage3=" + coverage3 + ", premiumAmount=" + premiumAmount + "]";
	}
	
	
}
