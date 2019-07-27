package com.glosys.lms.dao;


import com.glosys.lms.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class CourseDao extends AbstractDao<Course> {

   @Autowired
    public CourseDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Course> getAllCourse(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses ",e);
        }


    }

    public Optional<Course> getCourseByCourseId(Integer courseId){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.id=:courseId",Course.class);
            query.setParameter("courseId",courseId);
            entityManager.getTransaction().commit();
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e){
            return Optional.empty();
        }
        catch (Exception e) {
            if(entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new RuntimeException("can not get course for "+courseId,e);
        }


    }

    public Course updateCourseByCourseId(Course course){
        try {
            entityManager.getTransaction().begin();
            Course updatedCourse =  entityManager.merge(course);
            entityManager.getTransaction().commit();
            return  updatedCourse;

            /*Query query = entityManager.createQuery("UPDATE Course c SET c.name=:courseName, c.code=:courseCode, " +
                    "c.syllabus=:syllabus,c.courseCategory=:courseCategory,c.workshopEligibility=:workshopEligibility," +
                    "c.researchTrainingEligibility=:researchTrainingEligibility," +
                    "c.inplantTrainingEligibility=:inplantTrainingEligibility," +
                    " c.corporateTrainingEligibility=:corporateTrainingEligibility where c.id=:courseId");

            query.setParameter("courseName", course.getName());
            query.setParameter("courseCode", course.getCode());
            query.setParameter("syllabus",course.getSyllabus());
            query.setParameter("courseCategory",course.getCourseCategory());
            query.setParameter("workshopEligibility",course.isWorkshopEligibility());
            query.setParameter("researchTrainingEligibility", course.isResearchTrainingEligibility());
            query.setParameter("inplantTrainingEligibility", course.isResearchTrainingEligibility());
            query.setParameter("corporateTrainingEligibility", course.isCorporateTrainingEligibility());
            query.setParameter("courseId",courseId);

            int updateCount = query.executeUpdate();*/



        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not update courses for workshop",e);
        }
    }


    public List<Course> getCoursesForWorkshop() {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.workshopEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
           throw new RuntimeException("can not get courses for workshop",e);
        }

    }

    public List<Course> getCoursesForInplantTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.inplantTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses for Inplant training",e);
        }
    }

    public List<Course> getCoursesForCorporateTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.corporateTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses for Corporate Training",e);
        }
    }

    public List<Course> getCoursesForResearchTraining(){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.researchTrainingEligibility=TRUE",Course.class);
            entityManager.getTransaction().commit();
            return query.getResultList();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses for ResearchTraining",e);
        }
    }

    public boolean isExistingCourse(String courseCode){
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Course> query = entityManager.createQuery("SELECT course FROM Course course" +
                    " where course.code=:courseCode",Course.class);
            query.setParameter("courseCode",courseCode);
            entityManager.getTransaction().commit();
            if(query.getResultList().size() == 0){
                return false;
            }
            else{
                return true;
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException("can not get courses ",e);
        }



    }

    public void deleteCourse( Integer courseId) {
        try {
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }


}
