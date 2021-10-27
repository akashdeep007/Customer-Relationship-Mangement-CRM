package com.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers(int sort);

	public void saveCustomer(@Valid Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String name);
}
