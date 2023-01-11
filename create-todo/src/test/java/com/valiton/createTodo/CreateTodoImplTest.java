package com.valiton.createTodo;

import com.valiton.createTodo.data.CreateTodoData;
import com.valiton.createTodo.data.TodoData;
import com.valiton.createTodo.dataAccess.CreateTodoDataAccess;
import com.valiton.todo.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTodoImplTest {

    @Mock
    private CreateTodoDataAccess createTodoDataAccess;

    private CreateTodoImpl impl;

    @BeforeEach
    void setUp() {
        when(createTodoDataAccess.create(any())).thenAnswer(invocation -> {
            Todo todo = invocation.getArgument(0, Todo.class);
            return new Todo(1L, todo.getTitle(), todo.getDueDate(), todo.isDone());
        });
        impl = new CreateTodoImpl(createTodoDataAccess);
    }

    @Test
    public void testCreateTodo() {
        Date dueDate = new Date();

        CreateTodoData createTodoData = new CreateTodoData();
        createTodoData.title = "New Task";
        createTodoData.dueDate = dueDate;

        TodoData todoData = impl.create(createTodoData);

        assertNotNull(todoData.id);
        assertSame(todoData.title, "New Task");
        assertEquals(todoData.dueDate, dueDate);
        assertFalse(todoData.done);
    }
}