package com.ank.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ank.springdemo.dao.CustomerDAO;
import com.ank.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		List<Customer> custList=customerDAO.getCustomers();
		
		return custList;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int id) {
		Customer customer=customerDAO.getCustomers(id);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
	
		customerDAO.deleteCustomer(id);
	}

}
