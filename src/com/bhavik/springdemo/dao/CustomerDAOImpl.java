package com.bhavik.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhavik.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		/*
		 * saveOrUpdate method Hibernate logic
		 * 		if(primaryKey value is default) //in our case it is 0.
		 * 			then perform save operation
		 * 		else
		 * 			perform update operation.
		 * */
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		 * retrieve/read from database using the primary key
		 */
		
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
		
		
	}

}
