package com.valiton.todoDataAccess;

import com.valiton.todo.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FileBasedDataAccessTest {

    private FileBasedDataAccess fileBasedDataAccess;

    @BeforeEach
    void setUp() {
        File file = new File("db");
        file.delete();
        fileBasedDataAccess = new FileBasedDataAccess("db");
    }

    @Test
    public void testLoad() {
        assertSame(0, fileBasedDataAccess.findTodosNotDone().size());
    }

    @Test
    public void testCreate() {
        assertSame(0, fileBasedDataAccess.findTodosNotDone().size());

        fileBasedDataAccess.create(new Todo("Title", new Date()));
        List<Todo> todos = fileBasedDataAccess.findTodosNotDone();
        assertSame(1, todos.size());
        assertSame(1L, todos.get(0).getId());
    }
    @Test
    public void testUpdate() {
        Todo todo = fileBasedDataAccess.create(new Todo("Title", new Date()));
        todo.complete();
        fileBasedDataAccess.update(todo);
        todo = fileBasedDataAccess.find(todo.getId());
        assertTrue(todo.isDone());
    }
}