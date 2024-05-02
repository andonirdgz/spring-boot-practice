package com.andoni.springboot.course.webapp.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// [Moved this to a separate configuration class, it's cleaner] -> ValuesConfig
// @PropertySources({ @PropertySource("classpath:values.properties") })
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}
