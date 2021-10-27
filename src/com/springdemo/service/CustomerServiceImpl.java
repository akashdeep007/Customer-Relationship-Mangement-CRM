package com.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}
	


	@Override
	@Transactional
	public void saveCustomer(@Valid Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
	}



	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(id);
	}



	@Override
	@Transactional
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerDAO.deleteCustomer(id);
	}

}
