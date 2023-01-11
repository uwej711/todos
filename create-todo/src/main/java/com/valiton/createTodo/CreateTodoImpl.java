package com.valiton.createTodo;

import com.valiton.createTodo.data.CreateTodoData;
import com.valiton.createTodo.data.TodoData;
import com.valiton.createTodo.dataAccess.CreateTodoDataAccess;
import com.valiton.todo.Todo;

public class CreateTodoImpl implements CreateTodo {

    private final CreateTodoDataAccess dataAccess;

    public CreateTodoImpl(CreateTodoDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public TodoData create(CreateTodoData data) {
        Todo todo = new Todo(data.title, data.dueDate);
        todo = dataAccess.create(todo);

        return mapTodo(todo);
    }

    private static TodoData mapTodo(Todo todo) {
        TodoData todoData = new TodoData();

        todoData.id = todo.getId();
        todoData.title = todo.getTitle();
        todoData.dueDate = todo.getDueDate();
        todoData.done = todo.isDone();

        return todoData;
    }
}
