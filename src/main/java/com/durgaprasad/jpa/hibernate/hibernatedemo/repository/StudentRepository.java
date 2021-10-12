package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Passport;
import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
// Each method under the repository is run under the transaction feature
public class StudentRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public Student save(Student student){
        // save and update
        if(student.getId() == null){
            em.persist(student);
        }else{
            em.merge(student);
        }
        return student;
    }

    public void deleteById(Long id){
        Student student = findById(id);
        if(student != null){
            em.remove(student);
        }
    }

    // Hibernate is lazy in sending the data to the database
    // The real saving happens at the end of the function.
    // In case to push the changes to the database is to use em.flush()
    public void saveWithPassport(){
        Passport passport = new Passport("22334455");
        // A new id is generated and stored in the persistence context
        em.persist(passport);
        Student student = new Student("Web Services in 100 steps");
        student.setPassport(passport);
        save(student);
    }
}

