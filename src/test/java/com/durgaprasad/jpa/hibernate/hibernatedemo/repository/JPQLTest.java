package com.durgaprasad.jpa.hibernate.hibernatedemo.repository;

import com.durgaprasad.jpa.hibernate.hibernatedemo.HibernateDemoApplication;
import com.durgaprasad.jpa.hibernate.hibernatedemo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;


// Test cases to understand the working of the JPQL.
@SpringBootTest(classes = HibernateDemoApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    // Basic JPQL query
    @Test
    public void testBasicJPQL(){
       List resultList = em.createQuery("Select c from Course c").getResultList();
       logger.info("Select c from course c {}",  resultList);
   }

   // Typed JPQL query
    @Test
    public void testTypedJPQL(){
        TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c", Course.class);
        List resultList = typedQuery.getResultList();
        logger.info("Select c from c typed query {}", resultList);
    }

    // where JPQL query
    @Test
    public void testWhereJPQL(){
        TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c where id = 1", Course.class);
        logger.info("Select c from c where id = 1 {}", typedQuery.getResultList());
    }

    @Test
    public void testNamedQuery(){
        TypedQuery<Course> typedQuery = em.createNamedQuery("query_get_all_courses", Course.class);
        logger.info("Select c from c named query {}", typedQuery.getResultList());
    }


    @Test
    public void native_queries_basic(){
        Query query = em.createNativeQuery("SELECT * FROM course", Course.class);
        logger.info("Select course using native query {}", query.getResultList());
    }

    @Test
    // While doing mass updates to the database.
    // Writing a query very specific to the database.
    // Queries which are not supported by the JPA
    public void native_queries_with_parameters(){
        Query query = em.createNativeQuery("SELECT * FROM course where id in :ids", Course.class);
        query.setParameter("ids", Arrays.asList(1L, 2L));
        List resultList = query.getResultList();
        logger.info("native queries with parameters {}", resultList);

    }

}
