package com.ospedale.Task03.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfig {

	@Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // configure ModelMapper
        modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;
    }
	
}
