package org.tarzan.springtest.test;

import org.junit.Test;
import org.tarzan.springtest.entity.Customer;

public class ObjectTest {

	@Test
	public void getKey() {
		Customer c = new Customer("张", "三");
		String name = c.getClass().getName();
		System.out.println(name);

	}
}
