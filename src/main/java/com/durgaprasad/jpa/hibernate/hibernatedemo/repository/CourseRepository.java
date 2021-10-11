package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public Course save(Course course){
        // save and update
        if(course.getId() == null){
            em.persist(course);
        }else{
            em.merge(course);
        }
        return course;
    }

    public void deleteById(Long id){
        Course course = findById(id);
        if(course != null){
            em.remove(course);
        }
    }

    public void playWithEntityManager() {
        // Entire method is under a single transaction
        logger.info("playWithEntityManager - start");
        Course course  = new Course("Web Service in 100 steps");
        em.persist(course);
        em.flush();

        course.setName("Web Service in 100 steps - Updated");
        em.flush();

        Course course1 = new Course("Angular JS in 100 steps");
        em.persist(course1);
        em.flush();

        em.detach(course1);
        course1.setName("Angular JS in 100 steps updated");
        em.flush();

        Course course2 = new Course("React JS in 100 steps");
        em.persist(course2);
        em.flush();
        em.clear();
        course.setName("Web service is 100 revised");
        course2.setName("React JS in 100 steps updated");
    }
}
