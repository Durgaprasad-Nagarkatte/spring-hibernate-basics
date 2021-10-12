package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.HibernateDemoApplication;
import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Passport;
import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = HibernateDemoApplication.class)
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    // If one of the transactions fail, all the changes will be rolled back
    public void testData(){
        // Database Operation 1 - Retrieve student
        // All the variables are stored in persistent context
        // All the changes are kept track of in the persistent context
        Student student = em.find(Student.class, 20001L);

        // Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();

        // Database Operation 3 - update passport
        passport.setNumber("22334455");

        // Database Operation 4 - update passport
        student.setName("Durgaprasad - Updated");
    }

    // There is a eager fetch of details
    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void retrievePassportAndStudentDetails() {

        // Transaction ends after the em.find() method
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);

        // To establish the connection to the database and retrieve the data
        // we need transactional method
        logger.info("student -> {}", passport.getStudent());
    }


}