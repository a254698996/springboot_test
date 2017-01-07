package org.tarzan.springtest.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tarzan.springtest.dao.CustomerRepository;
import org.tarzan.springtest.entity.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerJPATest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private CustomerRepository repository;

	@Test
	public void testExample() throws Exception {
		Customer customer = new Customer("张", "三");
		this.entityManager.persist(customer);
		List<Customer> list = repository.findByFirstName("张");
		assertEquals(list.size(), 1, 1);
		Customer customer2 = list.get(0);
		assertEquals("张", customer2.getFirstName());
		assertEquals("三", customer2.getLastName());
		// assertThat(user.getVin()).isEqualTo("1234");
	}
}
