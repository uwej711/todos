package com.valiton.completeTodo;

import com.valiton.completeTodo.data.CompleteTodoData;
import com.valiton.completeTodo.data.TodoData;
import com.valiton.completeTodo.dataAccess.CompleteTodoDataAccess;
import com.valiton.todo.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompleteTodoImplTest {

    @Mock
    private CompleteTodoDataAccess dataAccess;

    private CompleteTodoImpl impl;

    @BeforeEach
    void setUp() {
        when(dataAccess.find(anyLong())).thenAnswer(invocation -> new Todo(invocation.getArgument(0), "Some Title", null, false));
        when(dataAccess.update(any())).thenAnswer(invocation -> invocation.getArgument(0));

        impl = new CompleteTodoImpl(dataAccess);
    }

    @Test
    public void testComplete() {
        CompleteTodoData completeTodoData = new CompleteTodoData();
        completeTodoData.id = 22L;

        TodoData completed = impl.complete(completeTodoData);

        assertTrue(completed.done);

        verify(dataAccess, times(1)).find(22L);
        verify(dataAccess, times(1)).update(any());
    }
}