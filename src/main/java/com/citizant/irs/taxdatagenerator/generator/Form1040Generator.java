package com.citizant.irs.taxdatagenerator.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.citizant.irs.taxdatagenerator.model.Dependent;
import com.citizant.irs.taxdatagenerator.model.Form1040;
import com.citizant.irs.taxdatagenerator.model.GeneratorConfig;
import com.citizant.irs.taxdatagenerator.model.Refund;
import com.citizant.irs.taxdatagenerator.model.TaxOwe;
import com.citizant.irs.taxdatagenerator.model.TaxPayment;
import com.citizant.irs.taxdatagenerator.model.TaxableIncome;
import com.citizant.irs.taxdatagenerator.model.USAddress;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Form1040Generator {

	private List<String> lastNames;
	private List<String> girlNames;
	private List<String> boyNames;
	private List<USAddress> addresses;

	// Load some lookup data
	public void init() {
		System.out.println("hshhsh");
		this.lastNames = loadFromFile("lastname.txt");
		this.girlNames = loadFromFile("girls.txt");
		this.boyNames = loadFromFile("boys.txt");
		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(getClass().getClassLoader().getResource("addresses-us-all.json").getFile());
		try {
			AddressHolder holder = objectMapper.readValue(file, AddressHolder.class);
			this.addresses = holder.getAddresses();
			System.out.println(this.addresses.get(10).getAddress1());			
		} catch (JsonParseException e) {		
			e.printStackTrace();
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}

	public List<Form1040> generateForm1040(GeneratorConfig config) {
	
		List<Form1040> forms = new ArrayList<Form1040>();
	
		//Generate records based on filling status
		//1. Single
		int count = (int)(config.getNumOfRecords() * config.getPerSingle() / 100);
		for(int i=0; i<count; i++) {
			Form1040 form = new Form1040("Single");		
			populateNames(form);
			populateDependents(form);
			form.setIncome(populateIncomes(form.getFillingStatus(), 50000));
			form.setPayment(populateTaxPayment(form.getIncome().getTaxableIncome(), form.getIncome().getWageSalary_1()));
			forms.add(form);
		}
		
		//2. Married Fill Jointly
		count = (int)(config.getNumOfRecords() * config.getPerMFJ() / 100);
		for(int i=0; i<count; i++) {
			Form1040 form = new Form1040("MFJ");		
			populateNames(form);
			populateDependents(form);
			form.setIncome(populateIncomes(form.getFillingStatus(), 110000));
			form.setPayment(populateTaxPayment(form.getIncome().getTaxableIncome(),form.getIncome().getWageSalary_1()));
			forms.add(form);
		}
		
		//3. Married Fill Separately
		count = (int)(config.getNumOfRecords() * config.getPerMFS() / 100);
		for(int i=0; i<count; i++) {
			Form1040 form = new Form1040("MFS");		
			populateNames(form);
			populateDependents(form);
			form.setIncome(populateIncomes(form.getFillingStatus(), 70000));
			form.setPayment(populateTaxPayment(form.getIncome().getTaxableIncome(),form.getIncome().getWageSalary_1()));
			forms.add(form);
		}
		
		//4. Head of Household
		count = (int)(config.getNumOfRecords() * config.getPerHOH() / 100);
		for(int i=0; i<count; i++) {
			Form1040 form = new Form1040("HOH");		
			populateNames(form);
			populateDependents(form);
			form.setIncome(populateIncomes(form.getFillingStatus(), 90000));
			form.setPayment(populateTaxPayment(form.getIncome().getTaxableIncome(),form.getIncome().getWageSalary_1()));
			forms.add(form);
		}
		
		//5. Qualified Widow
		count = (int)(config.getNumOfRecords() * config.getPerQW() / 100);
		for(int i=0; i<count; i++) {
			Form1040 form = new Form1040("QW");		
			populateNames(form);
			populateDependents(form);
			form.setIncome(populateIncomes(form.getFillingStatus(), 40000));
			form.setPayment(populateTaxPayment(form.getIncome().getTaxableIncome(), form.getIncome().getWageSalary_1()));
			forms.add(form);
		}
		
		//Find out refund or owe
		for(Form1040 form : forms) {
			//Set flags 
			
			
			long diff = form.getPayment().getTotalTax_16() - form.getPayment().getTotalPayments_19();
			if(diff > 0) {
				//Owe tax
				TaxOwe owe = new TaxOwe();
				owe.setAnountOwe_23(diff);
				owe.setEstimatedPenalty(0);
				form.setTaxOwe(owe);
			} else {
				Refund refund = new Refund();
				refund.setAmounToNextYear_22(0);
				refund.setOverpaid_20(-1 * diff);
				refund.setRefundAmount_21a(-1 * diff);
				refund.setAcountType("Checking");
				if(GeneratorUtils.isTrue(30.0)) {
					refund.setAcountType("Saving");
				}
				String routeNumber = GeneratorUtils.paddingNumber(GeneratorUtils.getRandomInt(10000, 300000), 9);
				String accountNumber = GeneratorUtils.paddingNumber(GeneratorUtils.getRandomInt(500000, 900000), 10);
				refund.setRouteNumber_21b(routeNumber);
				refund.setAccountNumber_21d(accountNumber);
				form.setRefund(refund);
			}
		}
		
		return forms;
	}
	
	
	public void populateNames(Form1040 form ) {
		boolean hasSpouse = !("Single".contentEquals(form.getFillingStatus()) || "QW".contentEquals(form.getFillingStatus()));
		//70% male and 30% female
		form.setLastName(this.lastNames.get(GeneratorUtils.getRandomInt(0,  999)));
		form.setSsn(GeneratorUtils.getSSN());
		if(GeneratorUtils.isTrue(70.0)) {
			form.setFirstName(this.boyNames.get(GeneratorUtils.getRandomInt(0,  999)));
			if(hasSpouse) {
				form.setSpouseFirstName(this.girlNames.get(GeneratorUtils.getRandomInt(0,  999)));
				form.setSpouseLastname(form.getLastName());
				form.setSpouseSsn(GeneratorUtils.getSSN());
			}
		} else {
			form.setFirstName(this.girlNames.get(GeneratorUtils.getRandomInt(0,  999)));
			if(hasSpouse) {
				form.setSpouseFirstName(this.boyNames.get(GeneratorUtils.getRandomInt(0,  999)));
				form.setSpouseLastname(form.getLastName());
				form.setSpouseSsn(GeneratorUtils.getSSN());
			}
		}
		USAddress address = this.addresses.get(GeneratorUtils.getRandomInt(0,  3220));
		form.setHomeAddress(address.getAddress1());
		form.setHomeCity(address.getCity());
		form.setHomeState(address.getState());
		form.setHomeZipCode(address.getPostalCode());
	}
	
	public void populateDependents(Form1040 form) {
		int count = GeneratorUtils.getRandomInt(0, 4);
		List<Dependent> dependents = new ArrayList<Dependent>();
		for(int i=0; i<count; i++) {
			Dependent d = new Dependent();
			d.setLastName(form.getLastName());
			d.setSsn(GeneratorUtils.getSSN());
			if(GeneratorUtils.isTrue(50.0)) {
				//Girl
				d.setChildTaxCredit(true);
				d.setFirstName(this.girlNames.get(GeneratorUtils.getRandomInt(0,  999)));	
				d.setRelationship("Daughter");
			} else {
				//Boy
				d.setCreditForOther(true);
				d.setFirstName(this.boyNames.get(GeneratorUtils.getRandomInt(0,  999)));	
				d.setRelationship("Son");
			}
			dependents.add(d);
		}
		form.setDependents(dependents);
	}
	
	
	/*
	 * This function try to generate income numbers that has
	 * a given mean average
	 */
	public TaxableIncome populateIncomes(String fillingStatus, long meanWage) {
		TaxableIncome income = new TaxableIncome();
		income.setWageSalary_1(GeneratorUtils.normalRandom(meanWage));
		long wage = income.getWageSalary_1();
		if(GeneratorUtils.isTrue(30)) {
			income.setTaxExemprInteret_2a(((long)(wage * 0.1)));
			income.setTaxableInterest_2b((long)(income.getTaxExemprInteret_2a() * 0.9));
		}
		if(GeneratorUtils.isTrue(20)) {
			income.setQualifiedDividends_3a((long)(wage * 0.3));
			income.setOrdiaryDividends_3b((long)(income.getQualifiedDividends_3a() * 0.6));
		}
		if(GeneratorUtils.isTrue(25)) {
			income.setSocialSecurity_5a(((long)(wage * 0.2)));
			income.setTaxableAmount_5b((long)(income.getSocialSecurity_5a() * 0.2));
		}		
		if(GeneratorUtils.isTrue(25)) {
			income.setCapitalGain_6((int)(wage * 0.2));
		}
		if(GeneratorUtils.isTrue(10)) {
			income.setAdjustIncome_8a((int)(wage * 0.15));
		}
		
		//Calculate standard deduction or itemized deduction. If use itemized
		//It should be larger than standard
		long standardDeduction = 12200;
		if("MFJ".equals(fillingStatus)) {
			standardDeduction = 24400;
		} else if ("HOH".equals(fillingStatus)) {
			standardDeduction = 18350;
		}
		if(GeneratorUtils.isTrue(15)) {
			standardDeduction = (long)(standardDeduction * (1.0 + Math.random()));
		}
		income.setDeduction_9(standardDeduction);
		
		if(GeneratorUtils.isTrue(5)) {
			income.setBesinessDeduction_10((int)(income.getWageSalary_1() * 0.17));
		}
		long totalIncome = income.getWageSalary_1() + income.getTaxableInterest_2b() + income.getOrdiaryDividends_3b() 
			+ income.getTaxableAmount_4b() + income.getTaxableAmount_4d() + income.getTaxableAmount_5b() + income.getCapitalGain_6();
		income.setTotalIncome_7b(totalIncome);
		
		if(GeneratorUtils.isTrue(15)) {
			income.setAdjustIncome_8a((long)(totalIncome * 0.11));
			income.setBesinessDeduction_10((long)(totalIncome * 0.07) );
		}
		income.setAdjustGrossIncome_8b(income.getTotalIncome_7b() - income.getAdjustGrossIncome_8b() );
		income.setAmount_11a(income.getBesinessDeduction_10() + income.getDeduction_9());
		long taxableIncome = income.getAdjustGrossIncome_8b() - income.getAmount_11a();
		if(taxableIncome < 0) {
			taxableIncome = 0;
		}
		income.setTaxableIncome(taxableIncome);
		
		return income;
	}
	
	public TaxPayment populateTaxPayment (long taxableIncome, long wage) {
		TaxPayment payment = new TaxPayment();
		payment.setTax_12a((int)(taxableIncome * 0.23));
		payment.setFederalWithhold_17((int)(wage * 0.15));
		
		payment.setTotalTax_16(payment.getTax_12a());
		payment.setTotalPayments_19(payment.getFederalWithhold_17());
		
		return payment;
	}
	

	public List<String> loadFromFile(String fileName) {
		List<String> values = new ArrayList<String>();
		File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
			String line;
			while ((line = br.readLine()) != null) {
				
				values.add(StringUtils.capitalize(line.trim().toLowerCase()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
}
