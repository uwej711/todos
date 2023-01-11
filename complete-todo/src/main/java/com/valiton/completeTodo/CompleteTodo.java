package com.valiton.completeTodo;

import com.valiton.completeTodo.data.CompleteTodoData;
import com.valiton.completeTodo.data.TodoData;

public interface CompleteTodo {
    TodoData complete(CompleteTodoData completeTodoData);
}
