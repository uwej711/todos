package com.valiton.todo;

import java.util.Date;

public class Todo {
    private Long id;
    private final String title;
    private final Long dueDate;
    private boolean done = false;

    public Todo(Long id, String title, Date dueDate, boolean done) {
        this.id = id;
        this.title = title;
        this.dueDate = dateToTimestamp(dueDate);
        this.done = done;
    }

    public Todo(String title, Date dueDate) {
        this.title = title;
        this.dueDate = dateToTimestamp(dueDate);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate != null ? new Date(dueDate) : null;
    }

    public boolean isDone() {
        return done;
    }

    public void complete() {
        done = true;
    }

    private Long dateToTimestamp(Date date) {
        return date != null ? date.getTime() : null;
    }
}
