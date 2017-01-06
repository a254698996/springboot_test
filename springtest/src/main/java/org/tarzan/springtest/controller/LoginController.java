package org.tarzan.springtest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class LoginController {

	static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@RequestMapping("/user")
	String home() {
		System.out.println("request comming " + sdf.format(new Date()));
		return "Hello World!";
	}
}
