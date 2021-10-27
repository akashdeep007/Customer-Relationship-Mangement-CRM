package com.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;
import com.springdemo.utils.SortingUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int sort) {
		// TODO Auto-generated method stub
String theFieldName = null;
		
		switch (sort) {
			case SortingUtils.FIRST_NAME: 
				theFieldName = "firstName";
				break;
			case SortingUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortingUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				theFieldName = "lastName";
		}
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from Customer order by " + theFieldName;
		Query<Customer> query = session.createQuery(queryString, Customer.class);
		List<Customer> customer = query.getResultList();			
		return customer;
	}

	@Override
	public void saveCustomer(@Valid Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer del = session.get(Customer.class,id);
		session.delete(del);
	}

}
