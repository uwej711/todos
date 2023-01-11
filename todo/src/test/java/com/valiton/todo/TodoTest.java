package com.valiton.todo;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TodoTest {

    @Test
    public void testNewTodoIsNotDone() {
        Date dueDate = new Date();
        Todo todo = new Todo("Title", dueDate);

        assertFalse(todo.isDone());
        assertSame("Title", todo.getTitle());
        assertEquals(dueDate, todo.getDueDate());
        assertNull(todo.getId());
    }

    @Test
    public void testComplete() {
        Todo todo = new Todo("Title", null);

        assertFalse(todo.isDone());
        todo.complete();
        assertTrue(todo.isDone());
    }
}