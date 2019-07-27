package com.glosys.lms.entities;

import com.glosys.lms.entities.CourseCategory;

import javax.persistence.*;

@Table(name = "course")
@Entity
public class Course implements LmsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "syllabus")
    private String syllabus;

    @ManyToOne
    @JoinColumn(name = "course_category_id",
            nullable=false, updatable=false)
    private CourseCategory courseCategory;

    @Column(name = "workshop_eligibility")
    private boolean workshopEligibility;

    @Column(name = "research_training_eligibility")
    private boolean researchTrainingEligibility;

    @Column(name = "inplant_training_eligibility")
    private boolean inplantTrainingEligibility;

    @Column(name = " corporate_training_eligibility")
    private boolean corporateTrainingEligibility;

    public Course() {

    }

    public Course(Integer id, String name, String code, String syllabus, CourseCategory courseCategory,
                  boolean workshopEligibility, boolean researchTrainingEligibility, boolean inplantTrainingEligibility, boolean corporateTrainingEligibility) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.syllabus = syllabus;
        this.courseCategory = courseCategory;
        this.workshopEligibility = workshopEligibility;
        this.researchTrainingEligibility = researchTrainingEligibility;
        this.inplantTrainingEligibility = inplantTrainingEligibility;
        this.corporateTrainingEligibility = corporateTrainingEligibility;
    }

    public Course(String name, String code, String syllabus, CourseCategory courseCategory, boolean workshopEligibility,
                  boolean researchTrainingEligibility, boolean inplantTrainingEligibility, boolean corporateTrainingEligibility) {
        this(null,name, code, syllabus, courseCategory, workshopEligibility, researchTrainingEligibility,
                inplantTrainingEligibility, corporateTrainingEligibility);
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

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    public CourseCategory getCourseCategory() {
        return courseCategory;
    }

    public void setCourseCategory(CourseCategory courseCategory) {
        this.courseCategory = courseCategory;
    }

    public boolean isWorkshopEligibility() {
        return workshopEligibility;
    }

    public void setWorkshopEligibility(boolean workshopEligibility) {
        this.workshopEligibility = workshopEligibility;
    }

    public boolean isResearchTrainingEligibility() {
        return researchTrainingEligibility;
    }

    public void setResearchTrainingEligibility(boolean researchTrainingEligibility) {
        this.researchTrainingEligibility = researchTrainingEligibility;
    }

    public boolean isInplantTrainingEligibility() {
        return inplantTrainingEligibility;
    }

    public void setInplantTrainingEligibility(boolean inplantTrainingEligibility) {
        this.inplantTrainingEligibility = inplantTrainingEligibility;
    }

    public boolean isCorporateTrainingEligibility() {
        return corporateTrainingEligibility;
    }

    public void setCorporateTrainingEligibility(boolean corporateTrainingEligibility) {
        this.corporateTrainingEligibility = corporateTrainingEligibility;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", syllabus='" + syllabus + '\'' +
                ", courseCategory=" + courseCategory +
                ", workshopEligibility=" + workshopEligibility +
                ", researchTrainingEligibility=" + researchTrainingEligibility +
                ", inplantTrainingEligibility=" + inplantTrainingEligibility +
                ", corporateTrainingEligibility=" + corporateTrainingEligibility +
                '}';
    }
}
