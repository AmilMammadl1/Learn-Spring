package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("username")
public class TodoControllerJpa {
    @Autowired
    private TodoService todoService;
    @Autowired
    private TodoRepository todoRepository;
    @RequestMapping("/todos")
    public String ListAllTodos(ModelMap modelMap) {
        String username = getLoggedInUser(modelMap);
        List<Todo2> list = todoRepository.findAll();
//        List<Todo> list = todoService.findAll();
//        List<Todo> list = todoService.findByUserName(username);
        modelMap.put("listForOneUser",list);
        return "listTodos";
    }
    public String getLoggedInUser(ModelMap modelMap){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    @RequestMapping(value = "/addtodo",method = RequestMethod.GET)
    public String goToAddTodoPage(ModelMap modelMap) {
        Todo2 todo = new Todo2(0,null,"",null,true);
        modelMap.put("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "/addtodo",method = RequestMethod.POST)
    public String goToTodoPage(ModelMap modelMap, @Valid Todo2 todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addTodo";
        }
        String username = getLoggedInUser(modelMap);
        todo.setUsername(username);
        todoRepository.save(todo);
//        todoService.addTodo(todo.getUsername(),todo.getDescription(),todo.getDate(),true);
        return "redirect:todos";
    }
    @RequestMapping("/deletetodos")
    public String DeleteTodosById(@RequestParam int id) {
        todoRepository.deleteById(id);
//        todoService.DeleteTodosById(id);
        return "redirect:todos";
    }
    @RequestMapping(value = "/updatetodos",method = RequestMethod.GET)
    public String updateTodosById(@RequestParam int id,ModelMap modelMap) {
//        Todo todo = todoService.findByUserId(id);
        Todo2 todo = todoRepository.findById(id).get();
        modelMap.put("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "/updatetodos",method = RequestMethod.POST)
    public String updateTodo(ModelMap modelMap, @Valid Todo2 todo, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "addTodo";
        }
        todo.setUsername(getLoggedInUser(modelMap));
        todoRepository.save(todo);
//        todoService.updateTodo(todo);
        return "redirect:todos";
    }
}
