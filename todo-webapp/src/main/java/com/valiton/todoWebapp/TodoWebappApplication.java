package com.valiton.todoWebapp;

import com.valiton.todoWebapp.createTodo.CreateTodoConfiguration;
import com.valiton.todoWebapp.listTodos.ListTodosConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
	DataAccessConfiguration.class,
	ListTodosConfiguration.class,
	CreateTodoConfiguration.class
})
public class TodoWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoWebappApplication.class, args);
	}

}
