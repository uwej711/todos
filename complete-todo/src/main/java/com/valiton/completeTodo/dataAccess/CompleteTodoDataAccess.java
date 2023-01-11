package com.valiton.completeTodo.dataAccess;

import com.valiton.todo.Todo;

public interface CompleteTodoDataAccess {
    Todo find(Long id);

    Todo update(Todo todo);
}
