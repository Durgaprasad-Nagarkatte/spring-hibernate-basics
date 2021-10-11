package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.HibernateDemoApplication;
import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HibernateDemoApplication.class)
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void findById() {
        Course course = repository.findById(10001L);
        assertEquals("JPA and Hibernate", course.getName());
    }

    @Test
    @DirtiesContext
    void deleteById() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    void save_whenUpdate() {
        Course course = repository.findById(10001L);
        course.setName("Functional Programming Updated");
        repository.save(course);
        assertEquals(repository.findById(10001L).getName(), "Functional Programming Updated");
    }
}