package com.in28minutes.learnjpaandhibernate.course.SpringDataJpa;

import com.in28minutes.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaRepository extends JpaRepository<Course,Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
    List<Course> findByAuthorAndName(String author,String name);


}
