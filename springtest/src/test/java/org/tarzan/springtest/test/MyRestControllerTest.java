package org.tarzan.springtest.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.tarzan.springtest.Application;
import org.tarzan.springtest.controller.MyRestController;
import org.tarzan.springtest.dao.CustomerRepository;
import org.tarzan.springtest.entity.Customer;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@WebMvcTest(MyRestController.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MyRestControllerTest {

	private MockMvc mvc;

	private Long id;
	@Autowired
	WebApplicationContext webApplicationConnect;

	@Autowired
	private CustomerRepository customerRepository;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationConnect).build();
		Customer customer = new Customer("lee", "bluce");
		Customer save = customerRepository.save(customer);
		id = save.getId();
	}

	@Test
	public void testExample() throws Exception {

		ResultActions andExpect = this.mvc.perform(delete("/customers/" + id).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		MockHttpServletResponse response = andExpect.andReturn().getResponse();
		// assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		System.out.println(response.getContentAsString());
		assertThat(response.getContentAsString()).contains("bluce");

	}
}
