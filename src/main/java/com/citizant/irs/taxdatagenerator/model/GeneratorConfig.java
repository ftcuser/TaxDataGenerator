package com.citizant.irs.taxdatagenerator.model;

public class GeneratorConfig {
	
	private long numOfRecords;
	private double perSingle;
	private double perMFJ;
	private double perMFS;
	private double perHOH;
	private double perQW;
	
	private String taxYear;
	private double perDependent;
	private double perBlind;
	private double perBornBefore1955;
	public long getNumOfRecords() {
		return numOfRecords;
	}
	public void setNumOfRecords(long numOfRecords) {
		this.numOfRecords = numOfRecords;
	}
	public double getPerSingle() {
		return perSingle;
	}
	public void setPerSingle(double perSingle) {
		this.perSingle = perSingle;
	}
	public double getPerMFJ() {
		return perMFJ;
	}
	public void setPerMFJ(double perMFJ) {
		this.perMFJ = perMFJ;
	}
	public double getPerMFS() {
		return perMFS;
	}
	public void setPerMFS(double perMFS) {
		this.perMFS = perMFS;
	}
	public double getPerHOH() {
		return perHOH;
	}
	public void setPerHOH(double perHOH) {
		this.perHOH = perHOH;
	}
	public double getPerQW() {
		return perQW;
	}
	public void setPerQW(double perQW) {
		this.perQW = perQW;
	}
	public String getTaxYear() {
		return taxYear;
	}
	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}
	public double getPerDependent() {
		return perDependent;
	}
	public void setPerDependent(double perDependent) {
		this.perDependent = perDependent;
	}
	public double getPerBlind() {
		return perBlind;
	}
	public void setPerBlind(double perBlind) {
		this.perBlind = perBlind;
	}
	public double getPerBornBefore1955() {
		return perBornBefore1955;
	}
	public void setPerBornBefore1955(double perBornBefore1955) {
		this.perBornBefore1955 = perBornBefore1955;
	}
	
	

}
