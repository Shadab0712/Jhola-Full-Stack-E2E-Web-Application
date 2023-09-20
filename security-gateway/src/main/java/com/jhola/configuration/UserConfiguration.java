package com.jhola.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

	@Bean
	public ModelMapper getModelmapper(){
		return new ModelMapper();
	}
}
