package com.valiton.todoWebapp.completeTodo;

import com.valiton.completeTodo.CompleteTodo;
import com.valiton.completeTodo.data.CompleteTodoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompleteTodoController {

    private final CompleteTodo completeTodo;

    public CompleteTodoController(CompleteTodo completeTodo) {
        this.completeTodo = completeTodo;
    }

    @PostMapping("/complete-todo")
    public String completeSubmit(@ModelAttribute CompleteTodoFormObject completeTodoFormObject, Model model) {
        CompleteTodoData completeTodoData = new CompleteTodoData();
        completeTodoData.id = completeTodoFormObject.getId();

        completeTodo.complete(completeTodoData);

        return "redirect:/";
    }
}
