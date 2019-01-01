package org.riskfirst.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class RiskfirstAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskfirstAutomationApplication.class, args);
	}

}

