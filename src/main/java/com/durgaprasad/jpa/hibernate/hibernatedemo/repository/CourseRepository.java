package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        if(course != null){
            em.remove(course);
        }
    }
}
