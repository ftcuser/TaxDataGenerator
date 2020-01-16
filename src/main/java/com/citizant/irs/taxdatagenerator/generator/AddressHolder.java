package com.citizant.irs.taxdatagenerator.generator;

import java.util.List;

import com.citizant.irs.taxdatagenerator.model.USAddress;

public class AddressHolder {
	private List<USAddress> addresses;
	private String[] attribution;
	public List<USAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<USAddress> addresses) {
		this.addresses = addresses;
	}
	public String[] getAttribution() {
		return attribution;
	}
	public void setAttribution(String[] attribution) {
		this.attribution = attribution;
	}
	
	
}
