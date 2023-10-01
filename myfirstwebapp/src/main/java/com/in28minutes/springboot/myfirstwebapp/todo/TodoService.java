package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo2> list = new ArrayList();
    private static int todosCound = 0;

    static {
        list.add(new Todo2(++todosCound, "Amil", "SpringBoot1", LocalDate.now().plusYears(1), true));
        list.add(new Todo2(++todosCound, "Amil", "SpringBoot2", LocalDate.now().plusYears(2), false));
        list.add(new Todo2(++todosCound, "Amil", "SpringBoot3", LocalDate.now().plusYears(3), false));
    }

    public List<Todo2> findAll() {
        return list;
    }

    public List<Todo2> findByUserName(String username) {
        Predicate<? super Todo2> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return list.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate date, Boolean done) {
        Todo2 todo = new Todo2(++todosCound, username, description, date, done);
        list.add(todo);
    }

    public void DeleteTodosById(int id) {
        Predicate<? super Todo2> predicate = todo -> todo.getId() == id;
        list.removeIf(predicate);

    }

    public Todo2 findByUserId(int id) {
        Predicate<? super Todo2> predicate = todo2 -> todo2.getId() == id;
        Todo2 t = list.stream().filter(predicate).findFirst().get();
        return t;
    }

    public void updateTodo(Todo2 todo) {
        DeleteTodosById(todo.getId());
        list.add(todo);
    }
}
