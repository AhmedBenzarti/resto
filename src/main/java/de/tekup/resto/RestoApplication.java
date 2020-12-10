package de.tekup.resto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestoApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(RestoApplication.class);
	
	public static void main(String[] args) {	
		SpringApplication.run(RestoApplication.class, args);
	}

}
