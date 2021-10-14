package com.durgaprasad.jpa.hibernate.hibernatedemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int rating;

    private String description;

    @ManyToOne
    private Course course;

    public Review(){}

    public Review(int rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
