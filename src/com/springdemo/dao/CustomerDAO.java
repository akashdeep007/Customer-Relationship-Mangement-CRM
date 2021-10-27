package com.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(@Valid Customer customer);

	public Customer getCustomer(int id);
}
