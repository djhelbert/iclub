package org.iclub.config;

import org.iclub.servlet.BinaryFileServlet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ServletConfig {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(BinaryFileServlet binaryFileServlet) {
        return new ServletRegistrationBean(binaryFileServlet, "/file");
    }

}
