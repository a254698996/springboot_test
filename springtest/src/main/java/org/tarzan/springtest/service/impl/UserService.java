package org.tarzan.springtest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tarzan.springtest.dao.CustomerRepository;
import org.tarzan.springtest.entity.Customer;
import org.tarzan.springtest.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer findById(String uid) {
		return customerRepository.findOne(Long.parseLong(uid));
	}

	@Override
	public Customer findByFirstName(String firlstName) {
		List<Customer> customerList = customerRepository.findByFirstName(firlstName);
		return customerList == null || customerList.isEmpty() ? null : customerList.get(0);
	}

}
