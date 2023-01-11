package com.valiton.todoConsole;

import com.valiton.completeTodo.CompleteTodo;
import com.valiton.completeTodo.CompleteTodoImpl;
import com.valiton.completeTodo.data.CompleteTodoData;
import com.valiton.createTodo.CreateTodo;
import com.valiton.createTodo.CreateTodoImpl;
import com.valiton.createTodo.data.CreateTodoData;
import com.valiton.createTodo.data.TodoData;
import com.valiton.listTodos.ListTodos;
import com.valiton.listTodos.ListTodosImpl;
import com.valiton.todoDataAccess.FileBasedDataAccess;

public class TodoConsole {

    private final ListTodos listTodos;
    private final CreateTodo createTodo;

    private final CompleteTodo completeTodo;

    public TodoConsole() {
        FileBasedDataAccess dataAccess = new FileBasedDataAccess("db");
        listTodos = new ListTodosImpl(dataAccess);
        createTodo = new CreateTodoImpl(dataAccess);
        completeTodo = new CompleteTodoImpl(dataAccess);
    }

    public static void main(String[] args) {
        TodoConsole console = new TodoConsole();

        console.run(args);
    }

    private void run(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                case "list" -> list();
                case "create" -> create(args);
                case "complete" -> complete(args);
                default -> usage();
            }
        } else {
            usage();
        }
    }

    private void usage() {
        System.out.println("Wrong usage!");
    }

    private void complete(String[] args) {
        if (args.length > 1) {
            CompleteTodoData completeTodoData = new CompleteTodoData();
            completeTodoData.id = Long.valueOf(args[1]);

            com.valiton.completeTodo.data.TodoData todoData = completeTodo.complete(completeTodoData);
            System.out.printf(
                "Id: %d, title: %s, due: %s, done: %s%n",
                todoData.id,
                todoData.title,
                todoData.dueDate != null ? todoData.toString() : "",
                todoData.done ? "yes" : "no"
            );
        } else {
            usage();
        }
    }

    private void create(String[] args) {
        if (args.length > 1) {
            CreateTodoData createTodoData = new CreateTodoData();
            createTodoData.title = args[1];
            TodoData todoData = createTodo.create(createTodoData);
            System.out.printf(
                "Id: %d, title: %s, due: %s, done: %s%n",
                todoData.id,
                todoData.title,
                todoData.dueDate != null ? todoData.toString() : "",
                todoData.done ? "yes" : "no"
            );
        } else {
            usage();
        }
    }

    private void list() {
        listTodos.list().forEach(todoData -> System.out.printf(
            "Id: %d, title: %s, due: %s, done: %s%n",
            todoData.id,
            todoData.title,
            todoData.dueDate != null ? todoData.toString() : "",
            todoData.done ? "yes" : "no"
        ));
    }
}
