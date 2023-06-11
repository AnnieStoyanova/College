package com.example.College.Course;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void addNewCourse(Course course) {
        courseRepo.saveAndFlush(course);
    }

    public Optional<Course> findById(Long id){
        return courseRepo.findById(id);
    }

    public List<Course> findAll(){
       return courseRepo.findAll();
    }
    @Transactional
    public void deleteCourse(Long courseId) {
        boolean exists = courseRepo.existsById(courseId);
        if(!exists){
            throw new IllegalArgumentException("Course with id" + courseId + "does not exist");
        }
        courseRepo.deleteById(courseId);
    }

}
