package com.in28minutes.springboot.learnspringboot;

public class Course {
    private long id;
    private String name;
    private String author;

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Course(long id, String name, String author) {
        this.author=author;
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id:" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
