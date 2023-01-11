package com.valiton.listTodos;

import com.valiton.listTodos.data.TodoData;
import com.valiton.listTodos.dataAccess.ListTodosDataAccess;
import com.valiton.todo.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListTodosImplTest {

    @Mock
    private ListTodosDataAccess dataAccess;

    private ListTodosImpl impl;

    @BeforeEach
    void setUp() {
        when(dataAccess.findTodosNotDone()).thenReturn(Arrays.asList(
            new Todo(1L, "first task", null, false),
            new Todo(2L, "second task", new Date(), false)
        ));

        impl = new ListTodosImpl(dataAccess);
    }

    @Test
    void testList() {
        List<TodoData> todos = impl.list();

        assertSame(2, todos.size());
        assertSame(1L, todos.get(0).id);
        assertSame(2L, todos.get(1).id);
    }
}