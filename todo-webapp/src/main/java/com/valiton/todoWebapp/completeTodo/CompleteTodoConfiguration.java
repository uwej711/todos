package com.valiton.todoWebapp.completeTodo;

import com.valiton.completeTodo.CompleteTodo;
import com.valiton.completeTodo.CompleteTodoImpl;
import com.valiton.completeTodo.dataAccess.CompleteTodoDataAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompleteTodoConfiguration {

    private final CompleteTodoDataAccess dataAccess;

    public CompleteTodoConfiguration(CompleteTodoDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Bean
    CompleteTodo createCompleteTodo() {
        return new CompleteTodoImpl(dataAccess);
    }
}
