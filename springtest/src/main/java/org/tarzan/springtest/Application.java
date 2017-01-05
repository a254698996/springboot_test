package org.tarzan.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration
						// @ComponentScan
public class Application {

	public static void main(String[] args) {
		// 设为 false 启动时 改写 代码 不会重启
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(Application.class, args);
	}

}