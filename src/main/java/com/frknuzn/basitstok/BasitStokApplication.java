package com.frknuzn.basitstok;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BasitStokApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasitStokApplication.class, args);
    }


    //Uygulama başladığında model mapper'ı oluştur ioc conteynera koy
    @Bean
    public ModelMapper getModelMapper(){

        ModelMapper modelMapper= new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
