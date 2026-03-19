package org.me._1_cheam_norakpanha_pvh_spring_homework002.service.Impl;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Course;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.CourseRequest;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.repository.CourseRepository;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {

        Integer offset = size * (page - 1);

        return courseRepository.getAllCourses(offset, size);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public Course createNewCourse(CourseRequest request) {
        return courseRepository.createNewCourse(request);
    }

    @Override
    public Course updateCourseById(Long courseId, CourseRequest request) {
        return courseRepository.updateCourseById(courseId, request);
    }

    @Override
    public int deleteCourseById(Long courseId) {
        return courseRepository.deleteCourseById(courseId);
    }
}
