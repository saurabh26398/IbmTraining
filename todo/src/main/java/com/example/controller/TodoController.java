package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.net.BindException;
import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/listTodo")
    public String listTodos(Model model) {
        model.addAttribute("todos",todoService.getTodos());
        return "todos";

    }

    @RequestMapping("/showForm")
    public String addTodo(Model model)
    {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }
    @RequestMapping("/processForm")
    public String processForm(@Valid  @ModelAttribute("todo") Todo todo, BindingResult theBindingResult){
        if (theBindingResult.hasErrors()){
            return "add-todo";
        }
        else {
            todoService.createTodo(todo);
            return "redirect:/todo/listTodo";
        }
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") int id)
    {
        todoService.deleteTodo(id);
        return "redirect:/todo/listTodo";
    }
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model)
    {
        Todo todo = todoService.getTodo(id);
        model.addAttribute("todo", todo);
        return "add-todo";
    }
    @RequestMapping("/updateTodo")
    public String updateTodo(@ModelAttribute("todo") Todo todo)
    {
        todoService.createTodo(todo);
        return "redirect:/todo/listTodo";
    }



}