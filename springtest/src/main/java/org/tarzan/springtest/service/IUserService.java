package org.tarzan.springtest.service;

import org.tarzan.springtest.entity.Customer;

public interface IUserService {
	public Customer findById(String uid);

	public Customer findByFirstName(String firlstName);

}
