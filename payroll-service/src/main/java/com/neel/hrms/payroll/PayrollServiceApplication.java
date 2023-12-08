package com.neel.hrms.payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
		exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class}
		)
@EnableJpaRepositories("com.neel.hrms.payroll.*")
@ComponentScans(value = {
		@ComponentScan("com.neel.hrms.payroll.*"),
		})
@EntityScan("com.neel.hrms.payroll.*")   
public class PayrollServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollServiceApplication.class, args);
	}

}
