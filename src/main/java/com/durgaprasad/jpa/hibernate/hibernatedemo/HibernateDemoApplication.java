package com.durgaprasad.jpa.hibernate.hibernatedemo;

import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Course;
import com.durgaprasad.jpa.hibernate.hibernatedemo.repository.CourseRepository;
import com.durgaprasad.jpa.hibernate.hibernatedemo.repository.StudentRepository;
import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// find by id
		Course course = courseRepository.findById(10001L);
		logger.info("The course is : {}", course);

		// delete by id
		courseRepository.deleteById(10003L);

		// save by id
		course = new Course("Functional Programming");
		courseRepository.save(course);

		courseRepository.playWithEntityManager();

		studentRepository.saveWithPassport();
	}
}
