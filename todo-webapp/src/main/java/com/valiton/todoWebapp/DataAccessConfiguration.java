package com.valiton.todoWebapp;

import com.valiton.todoDataAccess.FileBasedDataAccess;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAccessConfiguration {

    @Value("${app.db.filename}")
    private String filename;

    @Bean
    FileBasedDataAccess createDataAccess() {
        return new FileBasedDataAccess(filename);
    }
}
