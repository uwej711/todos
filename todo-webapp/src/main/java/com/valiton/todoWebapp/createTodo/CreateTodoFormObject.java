package com.valiton.todoWebapp.createTodo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateTodoFormObject {
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
