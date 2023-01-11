package com.valiton.listTodos;

import com.valiton.listTodos.data.TodoData;
import com.valiton.listTodos.dataAccess.ListTodosDataAccess;
import com.valiton.todo.Todo;

import java.util.List;

public class ListTodosImpl implements ListTodos {

    private final ListTodosDataAccess dataAccess;

    public ListTodosImpl(ListTodosDataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public List<TodoData> list() {
        List<Todo> todos = dataAccess.findTodosNotDone();

        return todos.stream().map(this::mapTodo).toList();
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
