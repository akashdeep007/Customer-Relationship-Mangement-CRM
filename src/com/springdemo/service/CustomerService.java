package com.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import com.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(int sort);

	public void saveCustomer(@Valid Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

}
