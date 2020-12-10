package de.tekup.resto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "de.tekup.resto.Rest","de.tekup.resto.Config","de.tekup.resto.service" })
public class RestoApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(RestoApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(RestoApplication.class, args);
	}

}
