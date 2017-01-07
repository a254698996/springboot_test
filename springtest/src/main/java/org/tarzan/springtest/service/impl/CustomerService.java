package org.tarzan.springtest.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.tarzan.springtest.dao.CustomerRepository;
import org.tarzan.springtest.entity.Customer;
import org.tarzan.springtest.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getCustomer(Long customer) {
		return customerRepository.findOne(customer);
	}

	@Override
	public Page<Customer> getUserCustomers(PageRequest pageRequest) {
		return customerRepository.findAll(pageRequest);
	}

	@Override
	@Transactional
	public void deleteCustomer(Long customer) {
		customerRepository.delete(customer);
	}

}
