package com.ank.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ank.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session=sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery=session.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> custList=theQuery.getResultList();
		
		return custList;
	}



	@Override
	public void saveCustomer(Customer customer) {
		
		Session session=sessionFactory.getCurrentSession();
		session.save(customer);
		
		
	}



	@Override
	public Customer getCustomers(int id) {
		Session session=sessionFactory.getCurrentSession();
		
		Query theQuery=session.createQuery("from Customer c where c.id=:id");
		theQuery.setParameter("id", id);
		Customer customer=(Customer) theQuery.getSingleResult();
		return customer;
	}



	@Override
	public void deleteCustomer(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Query theQuery=session.createQuery("DELETE from Customer c where c.id=:id");
		theQuery.setParameter("id", id);
		theQuery.executeUpdate();
		
	}

}
