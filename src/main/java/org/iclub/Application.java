package org.iclub;

import org.iclub.service.FreemarkerConfigService;
import org.iclub.service.SeedDataService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
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
public class Application extends SpringBootServletInitializer {

    /**
     * Main
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @ConditionalOnWebApplication
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            SeedDataService seedService = ctx.getBean(SeedDataService.class);
            if (seedService.init()) {
                FreemarkerConfigService service = ctx.getBean(FreemarkerConfigService.class);
                service.refresh();
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}