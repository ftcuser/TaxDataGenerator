package com.citizant.irs.taxdatagenerator.model;

import java.io.Serializable;
import java.util.List;

public class Form1040 implements Serializable {
	
	private String fillingStatus;
	private String firstName;
	private String lastName;
	private String ssn;
	private String spouseFirstName;
	private String spouseLastname;
	private String spouseSsn;
	private String homeAddress;
	private String homeCity;
	private String homeState;
	private String homeZipCode;
	
	private boolean youAsDependent = false;
	private boolean spouseAsDependent = false;
	private boolean spouseItemized = false;
	private boolean youBornBefore1955 = false;
	private boolean blind = false;
	private boolean spouseBornBefore1955 = false;
	private boolean spouseBlind = false;
	
	List<Dependent> dependents;
	
	TaxableIncome income;
	
	TaxPayment payment;
	
	TaxOwe taxOwe = null;
	
	Refund refund = null;
	
	public Form1040(String fillingStatus) {
		this.fillingStatus = fillingStatus;
	}

	public String getFillingStatus() {
		return fillingStatus;
	}

	public void setFillingStatus(String fillingStatus) {
		this.fillingStatus = fillingStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public void setSpouseFirstName(String spouseFirstName) {
		this.spouseFirstName = spouseFirstName;
	}

	public String getSpouseLastname() {
		return spouseLastname;
	}

	public void setSpouseLastname(String spouseLastname) {
		this.spouseLastname = spouseLastname;
	}

	public String getSpouseSsn() {
		return spouseSsn;
	}

	public void setSpouseSsn(String spouseSsn) {
		this.spouseSsn = spouseSsn;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public void setHomeCity(String homeCity) {
		this.homeCity = homeCity;
	}

	public String getHomeState() {
		return homeState;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public String getHomeZipCode() {
		return homeZipCode;
	}

	public void setHomeZipCode(String homeZipCode) {
		this.homeZipCode = homeZipCode;
	}

	public boolean isYouAsDependent() {
		return youAsDependent;
	}

	public void setYouAsDependent(boolean youAsDependent) {
		this.youAsDependent = youAsDependent;
	}

	public boolean isSpouseAsDependent() {
		return spouseAsDependent;
	}

	public void setSpouseAsDependent(boolean spouseAsDependent) {
		this.spouseAsDependent = spouseAsDependent;
	}

	public boolean isSpouseItemized() {
		return spouseItemized;
	}

	public void setSpouseItemized(boolean spouseItemized) {
		this.spouseItemized = spouseItemized;
	}

	public boolean isYouBornBefore1955() {
		return youBornBefore1955;
	}

	public void setYouBornBefore1955(boolean youBornBefore1955) {
		this.youBornBefore1955 = youBornBefore1955;
	}

	public boolean isBlind() {
		return blind;
	}

	public void setBlind(boolean blind) {
		this.blind = blind;
	}

	public boolean isSpouseBornBefore1955() {
		return spouseBornBefore1955;
	}

	public void setSpouseBornBefore1955(boolean spouseBornBefore1955) {
		this.spouseBornBefore1955 = spouseBornBefore1955;
	}

	public boolean isSpouseBlind() {
		return spouseBlind;
	}

	public void setSpouseBlind(boolean spouseBlind) {
		this.spouseBlind = spouseBlind;
	}

	
	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	public TaxableIncome getIncome() {
		return income;
	}

	public void setIncome(TaxableIncome income) {
		this.income = income;
	}

	public TaxPayment getPayment() {
		return payment;
	}

	public void setPayment(TaxPayment payment) {
		this.payment = payment;
	}

	public TaxOwe getTaxOwe() {
		return taxOwe;
	}

	public void setTaxOwe(TaxOwe taxOwe) {
		this.taxOwe = taxOwe;
	}

	public Refund getRefund() {
		return refund;
	}

	public void setRefund(Refund refund) {
		this.refund = refund;
	}
	
	
	
}
