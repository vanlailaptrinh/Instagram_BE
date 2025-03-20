package com.instagram.security.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
