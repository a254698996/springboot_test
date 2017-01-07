package org.tarzan.springtest.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.tarzan.springtest.entity.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstName(String firstName);

}