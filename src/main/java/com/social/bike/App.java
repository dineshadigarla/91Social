package com.social.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Configuration
@Slf4j
@ComponentScan({"com.social.bike","com.social.assembly.impl","com.social.handlebar.impl","com.social.seating.impl","com.social.wheel.impl"})
public class App implements CommandLineRunner 
{
	
	@Autowired
	private CycleTask bikeTask;

	public static void main( String[] args )
	{
		SpringApplication.run(App.class, args);	
	}

	public void run(String... args) throws Exception {
		for (int i = 0; i < args.length; ++i) {
			log.info("args[{}]: {}", i, args[i]);
        }
		
		bikeTask.totalPrice(args[0]);
		
	}

}
