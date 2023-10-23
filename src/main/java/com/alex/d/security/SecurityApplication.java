package com.alex.d.security;

import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.handler.MappedInterceptor;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecurityApplication {

private final static Logger LOGGER = LogManager.getLogger(SecurityApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
        LOGGER.debug("Debugging log");
        LOGGER.info("Info log");

    }



    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
        return registry -> registry.config().commonTags("application", "spring-boot-prjct");
    }


}
