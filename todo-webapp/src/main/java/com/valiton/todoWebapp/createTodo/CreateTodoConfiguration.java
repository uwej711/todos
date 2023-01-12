package com.valiton.todoWebapp.createTodo;

import com.valiton.createTodo.CreateTodo;
import com.valiton.createTodo.CreateTodoImpl;
import com.valiton.createTodo.dataAccess.CreateTodoDataAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateTodoConfiguration {

    private CreateTodoDataAccess dataAccess;

    public CreateTodoConfiguration(CreateTodoDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Bean
    CreateTodo createCreateTodo() {
        return new CreateTodoImpl(dataAccess);
    }
}
