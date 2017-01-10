package org.tarzan.springtest.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.tarzan.springtest.entity.Customer;

public interface CustomerRepository extends BaseDao<Customer, Long> {

	@Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
	List<Customer> findByLastName(String lastName);

	@Cacheable(value = "usercache", keyGenerator = "wiselyKeyGenerator")
	List<Customer> findByFirstName(String firstName);

	// @Override
	// @Cacheable(value = "remote", key = "'USER_NAME_'+#args[0]")
	// default <S extends Customer> S save(S arg0) {
	// // TODO Auto-generated method stub
	// return null;
	// }
}