package com.in28minutes.springboot.myfirstwebapp.todo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo2,Integer> {
    public List<Todo2> findByUsername(String username);
}
