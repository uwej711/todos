package com.valiton.todoWebapp.listTodos;

import com.valiton.listTodos.ListTodos;
import com.valiton.listTodos.ListTodosImpl;
import com.valiton.listTodos.dataAccess.ListTodosDataAccess;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListTodosConfiguration {

    private final ListTodosDataAccess dataAccess;

    public ListTodosConfiguration(ListTodosDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Bean
    ListTodos createListTodos() {
        return new ListTodosImpl(dataAccess);
    }
}
