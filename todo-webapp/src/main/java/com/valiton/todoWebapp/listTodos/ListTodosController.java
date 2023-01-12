package com.valiton.todoWebapp.listTodos;

import com.valiton.listTodos.ListTodos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListTodosController {
    private final ListTodos listTodos;

    public ListTodosController(ListTodos listTodos) {
        this.listTodos = listTodos;
    }

    @GetMapping("/")
    public String todos(Model model) {
        model.addAttribute("todos", listTodos.list());
        return "listTodos";
    }
}