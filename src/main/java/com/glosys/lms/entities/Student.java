package com.glosys.lms.entities;

import javax.persistence.*;

@Entity
@Table(name = "student")

public class Student implements LmsEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "mail_id")
    private String mailId;
    @Column(name = "college_name")
    private String collegeName;
    @Column (name = "passwordd")
    private String password;

    public Student() {
    }


    public Student(String firstName, String lastName, String gender, String mailId, String collegeName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mailId = mailId;
        this.collegeName = collegeName;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
