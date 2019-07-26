package com.glosys.lms;

import javax.persistence.*;

@Table(name = "course_category")
@Entity

public class CourseCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_category_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public CourseCategory() {
    }

    public CourseCategory(Integer id) {
        this.id = id;
    }

    public CourseCategory(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
