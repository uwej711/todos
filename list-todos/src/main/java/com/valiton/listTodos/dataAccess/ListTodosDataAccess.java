package com.valiton.listTodos.dataAccess;

import com.valiton.todo.Todo;

import java.util.List;

public interface ListTodosDataAccess {
    List<Todo> findTodosNotDone();
}
