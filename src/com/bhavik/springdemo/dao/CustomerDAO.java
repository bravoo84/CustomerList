package com.bhavik.springdemo.dao;

import java.util.List;

import com.bhavik.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
