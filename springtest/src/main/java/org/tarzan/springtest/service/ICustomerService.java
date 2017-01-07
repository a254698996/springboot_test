package org.tarzan.springtest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.tarzan.springtest.entity.Customer;

public interface ICustomerService {
	public Customer getCustomer(Long customer);

	public Page<Customer> getUserCustomers(PageRequest pageRequest);

	public void deleteCustomer(Long customer);
}
