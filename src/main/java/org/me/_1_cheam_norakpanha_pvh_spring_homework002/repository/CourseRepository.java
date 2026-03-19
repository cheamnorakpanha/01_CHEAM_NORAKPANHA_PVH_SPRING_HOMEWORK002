package org.me._1_cheam_norakpanha_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Course;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "org.me._1_cheam_norakpanha_pvh_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
            SELECT * FROM courses OFFSET #{offset} LIMIT #{size}
            """)
    List<Course> getAllCourses(Integer offset, Integer size);

    @ResultMap("courseMapper")
    @Select("""
            SELECT * FROM courses WHERE course_id = #{courseId}
            """)
    Course getCourseById(Long courseId);

    @ResultMap("courseMapper")
    @Select("""
            INSERT INTO courses (course_name, description, instructor_id)
            VALUES (#{req.courseName}, #{req.description}, #{req.instructor.instructorId})
            RETURNING *
            """)
    Course createNewCourse(@Param("req") CourseRequest request);

    @ResultMap("courseMapper")
    @Select("""
            UPDATE courses
            SET course_name = #{req.courseName}, description = #{req.description}, instructor_id = #{req.instructor.instructorId}
            WHERE course_id = #{courseId} RETURNING *
            """)
    Course updateCourseById(Long courseId, @Param("req") CourseRequest request);

    @Delete("""
            DELETE FROM courses WHERE course_id = #{courseId} RETURNING *
            """)
    Course deleteCourseById(Long courseId);
}
