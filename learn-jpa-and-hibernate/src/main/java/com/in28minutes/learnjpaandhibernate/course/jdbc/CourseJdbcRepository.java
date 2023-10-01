package com.in28minutes.learnjpaandhibernate.course.jdbc;

import com.in28minutes.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate SpringJdbcTemplate;

    public void insert(Course course) {
        SpringJdbcTemplate.update("insert into course (id,name ,author) values (?,?,?)",
                course.getId(),
                course.getName(),
                course.getAuthor()
        );
    }

    public void delete(Course course) {
        SpringJdbcTemplate.update("delete from course where id=?",
                course.getId()
        );
    }

    public Course select(int id) {
        return SpringJdbcTemplate.queryForObject("select * from course where id=?", new BeanPropertyRowMapper<>(Course.class), id);
    }
}
