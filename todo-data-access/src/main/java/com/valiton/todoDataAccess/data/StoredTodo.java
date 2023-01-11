package com.valiton.todoDataAccess.data;

import java.io.Serializable;
import java.util.Date;

public class StoredTodo implements Serializable {
    public String title;
    public Date dueDate;
    public boolean done;
}
