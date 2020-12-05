package com.CarRental;

import com.CarRental.model.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan({"com.CarRental"})
public class CarRentalApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CarRentalApplication.class, args);
		Admin admin = context.getBean(Admin.class);
		admin.setId(1);
		admin.setAdminName("admin");
		admin.setNo("9673426888");
	}
}
