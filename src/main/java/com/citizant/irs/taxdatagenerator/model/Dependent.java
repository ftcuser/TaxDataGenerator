package com.citizant.irs.taxdatagenerator.model;

import java.io.Serializable;

public class Dependent implements Serializable {
	
	private String firstName;
	private String lastName;
	private String ssn;
	private String relationship;
	private boolean childTaxCredit = false;
	private boolean creditForOther = false;
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
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public boolean isChildTaxCredit() {
		return childTaxCredit;
	}
	public void setChildTaxCredit(boolean childTaxCredit) {
		this.childTaxCredit = childTaxCredit;
	}
	public boolean isCreditForOther() {
		return creditForOther;
	}
	public void setCreditForOther(boolean creditForOther) {
		this.creditForOther = creditForOther;
	}
	
	
	

}
