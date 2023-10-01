package com.in28minutes.learnjpaandhibernate.course;

import com.in28minutes.learnjpaandhibernate.course.Course;
import com.in28minutes.learnjpaandhibernate.course.Jpa.CourseJpaRepository;
import com.in28minutes.learnjpaandhibernate.course.SpringDataJpa.SpringDataJpaRepository;
import com.in28minutes.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
//    @Autowired
//    private CourseJdbcRepository courseJdbcRepository;

    //    @Autowired
//    private CourseJpaRepository CourseJpaRepository;
    @Autowired
    private SpringDataJpaRepository springDataJpaRepository;


    @Override
    public void run(String... args) throws Exception {


        springDataJpaRepository.save(new Course(1, "a", "b"));
        springDataJpaRepository.save(new Course(2, "c", "d"));
        springDataJpaRepository.save(new Course(3, "e", "f"));
        springDataJpaRepository.deleteById(1L);
        System.out.println(springDataJpaRepository.findById(2L));
        System.out.println(springDataJpaRepository.findById(3L));

        System.out.println("========================================================");
        System.out.println(springDataJpaRepository.findAll());
        System.out.println(springDataJpaRepository.count());
        System.out.println(springDataJpaRepository.findByAuthor("f"));
        System.out.println(springDataJpaRepository.findByAuthor(""));
        System.out.println(springDataJpaRepository.findByName("c"));
        System.out.println(springDataJpaRepository.findByAuthorAndName("d","c"));


//        CourseJpaRepository.insert(new Course(1, "a", "b"));
//        CourseJpaRepository.insert(new Course(2, "c", "d"));
//        CourseJpaRepository.insert(new Course(3, "e", "f"));
//        CourseJpaRepository.delete(1);
//        System.out.println(CourseJpaRepository.findById(2));
//        System.out.println(CourseJpaRepository.findById(3));


//        courseJdbcRepository.insert(new Course(1, "a", "b"));
//        courseJdbcRepository.insert(new Course(2, "c", "d"));
//        courseJdbcRepository.insert(new Course(3, "e", "f"));
//        courseJdbcRepository.delete(new Course(1));
//        System.out.println(courseJdbcRepository.select(2));
//        System.out.println(courseJdbcRepository.select(3));

    }
}
