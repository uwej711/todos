package com.valiton.completeTodo;

import com.valiton.completeTodo.data.CompleteTodoData;
import com.valiton.completeTodo.data.TodoData;
import com.valiton.completeTodo.dataAccess.CompleteTodoDataAccess;
import com.valiton.todo.Todo;

public class CompleteTodoImpl implements CompleteTodo {
    private final CompleteTodoDataAccess dataAccess;

    public CompleteTodoImpl(CompleteTodoDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public TodoData complete(CompleteTodoData completeTodoData) {
        Todo todo = dataAccess.find(completeTodoData.id);

        todo.complete();

        todo = dataAccess.update(todo);

        return mapTodo(todo);
    }

    private TodoData mapTodo(Todo todo) {
        TodoData todoData = new TodoData();

        todoData.id = todo.getId();
        todoData.title = todo.getTitle();
        todoData.dueDate = todo.getDueDate();
        todoData.done = todo.isDone();

        return todoData;
    }
}
