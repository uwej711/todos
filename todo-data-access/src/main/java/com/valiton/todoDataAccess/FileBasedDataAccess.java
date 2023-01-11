package com.valiton.todoDataAccess;

import com.valiton.completeTodo.dataAccess.CompleteTodoDataAccess;
import com.valiton.createTodo.dataAccess.CreateTodoDataAccess;
import com.valiton.listTodos.dataAccess.ListTodosDataAccess;
import com.valiton.todo.Todo;
import com.valiton.todoDataAccess.data.StoredTodo;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileBasedDataAccess implements CreateTodoDataAccess, CompleteTodoDataAccess, ListTodosDataAccess {

    private Map<Long, StoredTodo> todos;
    private final String filename;

    public FileBasedDataAccess(String filename) {
        this.filename = filename;
        load();
    }

    @Override
    public Todo find(Long id) {
        return mapStoredTodo(id, todos.get(id));
    }

    @Override
    public Todo update(Todo todo) {
        todos.put(todo.getId(), mapTodo(todo));

        save();

        return todo;
    }

    @Override
    public Todo create(Todo todo) {
        long id = todos.values().size() + 1;
        StoredTodo storedTodo = mapTodo(todo);
        todos.put(id, storedTodo);

        save();

        return mapStoredTodo(id, storedTodo);
    }

    @Override
    public List<Todo> findTodosNotDone() {
        return todos.entrySet().stream().filter(entry -> !entry.getValue().done).map(entry -> mapStoredTodo(entry.getKey(), entry.getValue())).toList();
    }

    private void load() {
        File file = new File(filename);
        if (!file.exists()) {
            todos = new HashMap<>();

            return;
        }

        try {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                todos = (Map<Long, StoredTodo>) objectInputStream.readObject();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void save() {
        try {
            try (FileOutputStream outputStream = new FileOutputStream(filename)) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(todos);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Todo mapStoredTodo(Long id, StoredTodo storedTodo) {
        return new Todo(id, storedTodo.title, storedTodo.dueDate, storedTodo.done);
    }

    private StoredTodo mapTodo(Todo todo) {
        StoredTodo storedTodo = new StoredTodo();

        storedTodo.title = todo.getTitle();
        storedTodo.dueDate = todo.getDueDate();
        storedTodo.done = todo.isDone();

        return storedTodo;
    }
}
