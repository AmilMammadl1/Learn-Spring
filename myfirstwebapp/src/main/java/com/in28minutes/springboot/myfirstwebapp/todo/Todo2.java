package com.in28minutes.springboot.myfirstwebapp.todo;
//
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
@Entity
public class Todo2 {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "USERNAME")
    private String username;
    @Size(min = 3,message = "e xiar en az 3 herf olmalidi")
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "DONE")
    private boolean done;
    public Todo2() {

    }
    public Todo2(int id, String username, String description, LocalDate date, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", done=" + done +
                '}';
    }
}
