package org.tarzan.springtest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.tarzan.springtest.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstName(String firstName);

}