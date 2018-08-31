package com.exochain.ice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.exochain.ice"})
public class BootServer {

	public static void main(String[] args) {
		SpringApplication.run(BootServer.class, args);
	}
}
