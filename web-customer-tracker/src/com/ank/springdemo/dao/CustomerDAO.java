package com.ank.springdemo.dao;

import java.util.List;

import com.ank.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);
}
