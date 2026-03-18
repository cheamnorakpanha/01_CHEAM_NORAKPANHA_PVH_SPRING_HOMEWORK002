package org.me._1_cheam_norakpanha_pvh_spring_homework002.service;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Course;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.CourseRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Long courseId);

    Course createNewCourse(CourseRequest request);
}
