package com.bhavik.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bhavik.springdemo.dao.CustomerDAO;
import com.bhavik.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		
		theModel.addAttribute("customers", theCustomers);
		
		
		int temp = 1000;
		
		if(theCustomers!=null) temp = theCustomers.size();
		
		theModel.addAttribute("temp", temp);
		
		
		return "list-customers";
	}
	
}

