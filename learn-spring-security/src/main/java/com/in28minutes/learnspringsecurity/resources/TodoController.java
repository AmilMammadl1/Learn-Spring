package com.in28minutes.learnspringsecurity.resources;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static final List<Todo> TODOS = List.of(new Todo("amil", "pisiy"), new Todo("amil2", "pisiy2"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return TODOS;
    }

    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username == authentication.name")
    @PostAuthorize("returnObject.username == 'amil'")
    @RolesAllowed({"ADMIN", "USER"})
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Todo retrieveTodosForSpecificUser(@PathVariable String username) {
        return TODOS.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("create {} for {}", todo, username);
    }

    @PutMapping("/users/{username}/todos")
    public void updateTodosForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
        logger.info("create {} for {}", todo, username);
    }
}

record Todo(String username, String description) {
}
