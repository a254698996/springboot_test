package org.tarzan.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.tarzan.springtest.entity.Customer;
import org.tarzan.springtest.service.ICustomerService;

@RestController
@RequestMapping(value = "/customers")
public class MyRestController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/{customer}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long customer) {
		return customerService.getCustomer(customer);
	}

	@RequestMapping(value = "/{customer}/customers", method = RequestMethod.GET)
	public Page<Customer> getUserCustomers(@PathVariable Long customer) {
		PageRequest pageRequest = new PageRequest(0, 2);
		return customerService.getUserCustomers(pageRequest);
	}

	@RequestMapping(value = "/{customer}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Customer deleteCustomer(@PathVariable Long customer) {
		Customer customer2 = customerService.getCustomer(customer);
		customerService.deleteCustomer(customer);
		return customer2;
	}

}