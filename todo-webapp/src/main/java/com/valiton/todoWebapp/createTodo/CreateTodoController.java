package com.valiton.todoWebapp.createTodo;

import com.valiton.createTodo.CreateTodo;
import com.valiton.createTodo.data.CreateTodoData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreateTodoController {

    private final CreateTodo createTodo;

    public CreateTodoController(CreateTodo createTodo) {
        this.createTodo = createTodo;
    }

    @GetMapping("/create-todo")
    public String createForm(Model model) {
        model.addAttribute("createTodoFormObject", new CreateTodoFormObject());

        return "createTodo";
    }

    @PostMapping("/create-todo")
    public String createSubmit(@ModelAttribute CreateTodoFormObject createTodoFormObject, Model model) {
        CreateTodoData createTodoData = new CreateTodoData();
        createTodoData.title = createTodoFormObject.getTitle();
        createTodoData.dueDate = createTodoFormObject.getDueDate();

        createTodo.create(createTodoData);

        return "redirect:/";
    }
}
