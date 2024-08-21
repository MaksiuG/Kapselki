package com.kapselki.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapp {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
