package com.citizant.irs.taxdatagenerator.controller;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citizant.irs.taxdatagenerator.generator.Form1040Generator;
import com.citizant.irs.taxdatagenerator.model.Form1040;
import com.citizant.irs.taxdatagenerator.model.GeneratorConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WebController {
	 /**
     * GET HMS Users
     */
    @GetMapping("/")
    public String getHomePage() {
    	return "login";
    }
    
    @PostMapping("/login")
    public String login() {    	
    	return "dashboard";
    }
    
    @PostMapping("/generateData")
    public String generateData(@ModelAttribute GeneratorConfig config, Model model, HttpServletRequest request) {
    	Form1040Generator gen = new Form1040Generator();
    	gen.init();
    	List<Form1040> forms = gen.generateForm1040(config);
    	model.addAttribute("forms", forms);
    	model.addAttribute("taxYear", config.getTaxYear());
    	request.getSession().setAttribute("GEN_FORMS", forms);
    	return "controls";
    }
    
    @GetMapping("/showDetails")
    @ResponseBody
    public String getDetails( HttpServletRequest request, HttpServletResponse response) {
    	List<Form1040> forms = (List<Form1040>)request.getSession().getAttribute("GEN_FORMS");
    	int index = Integer.parseInt(request.getParameter("index"));
    	Form1040 form = forms.get(index);
    	ObjectMapper objectMapper = new ObjectMapper();
    	response.setContentType("application/json");
    	String indented = "";
    	try {
			indented = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(form);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return indented;
    }
    
    @GetMapping("/download")
    public void download( HttpServletRequest request, HttpServletResponse response) {
    	List<Form1040> forms = (List<Form1040>)request.getSession().getAttribute("GEN_FORMS");
    	ObjectMapper objectMapper = new ObjectMapper();
    	try {
			String jsonStr = objectMapper.writeValueAsString(forms);
			response.setContentType("application/json");  
			response.setHeader("Content-disposition", "attachment; filename=tax2019_Form1040sample.json");
		    OutputStream out = response.getOutputStream();
		    out.write(jsonStr.getBytes());
		    out.flush();
		    out.close();
		} catch (Exception e) {		
			e.printStackTrace();
		} 
   	 	
    }
}
