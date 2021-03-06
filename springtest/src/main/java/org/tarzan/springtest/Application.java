package org.tarzan.springtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.tarzan.springtest.dao.CustomerRepository;
import org.tarzan.springtest.entity.Customer;
 

//same as @Configuration @EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		// 设为 false 启动时 改写 代码 不会重启
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Application.class );
	}
	
//	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Bean
//	public CommandLineRunner h2Jdbc() {
//		return (args) -> {
//		log.info("Creating tables");
//
//		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
//		jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
//
//		// Split up the array of whole names into an array of first/last names
//		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
//				.map(name -> name.split(" ")).collect(Collectors.toList());
//
//		// Use a Java 8 stream to print out each tuple of the list
//		splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
//
//		// Uses JdbcTemplate's batchUpdate operation to bulk load data
//		jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
//
//		log.info("Querying for customer records where first_name = 'Josh':");
//		jdbcTemplate
//				.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?",
//						new Object[] { "Josh" }, (rs, rowNum) -> new hello.Customer(rs.getLong("id"),
//								rs.getString("first_name"), rs.getString("last_name")))
//				.forEach(customer -> log.info(customer.toString()));
//		};
//	}

}