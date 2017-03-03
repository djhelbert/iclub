package org.iclub;

import org.iclub.service.SeedDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main Application
 *
 */
@SpringBootApplication
@ComponentScan("org.iclub") 
@EnableAutoConfiguration
public class Application {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        	SeedDataService service = ctx.getBean(SeedDataService.class);
            service.init();
        };
    }
    
}