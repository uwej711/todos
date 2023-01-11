package com.valiton.createTodo;

import com.valiton.createTodo.data.CreateTodoData;
import com.valiton.createTodo.data.TodoData;

public interface CreateTodo {
    public TodoData create(CreateTodoData data);
}
