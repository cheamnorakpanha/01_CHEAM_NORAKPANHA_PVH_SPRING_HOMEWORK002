package org.me._1_cheam_norakpanha_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Student;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.StudentRequest;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id", many = @Many(select = "org.me._1_cheam_norakpanha_pvh_spring_homework002.repository.CourseRepository.getCoursesByStudentId"))
    })
    @Select("""
            SELECT * FROM students OFFSET #{offset} LIMIT #{size}
            """)
    List<Student> getAllStudents(Integer offset, Integer size);

    @ResultMap("studentMapper")
    @Select("""
            SELECT * FROM students WHERE student_id = #{studentId}
            """)
    Student getStundentById(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
            INSERT INTO students (student_name, email, phone_number)
            VALUES (#{req.studentName}, #{req.email}, #{req.phoneNumber})
            RETURNING *
            """)
    Student createNewStudent(@Param("req") StudentRequest request);

    @Insert("""
                INSERT INTO student_course (student_id, course_id)
                VALUES (#{studentId}, #{courseId})
            """)
    void insertStudentCourse(@Param("studentId") Long studentId,
                             @Param("courseId") Long courseId);


    @ResultMap("studentMapper")
    @Select("""
                UPDATE students
                SET student_name = #{req.studentName}, email = #{req.email}, phone_number = #{req.phoneNumber}
                WHERE student_id = #{studentId} RETURNING *
            """)
    Student updateStudentById(Long studentId, @Param("req") StudentRequest request);

    @Delete("""
            DELETE FROM student_course WHERE student_id = #{studentId}
            """)
    void deleteStudentCourse(Long studentId);

    @ResultMap("studentMapper")
    @Select("""
                DELETE FROM students WHERE student_id = #{studentId} RETURNING *
            """)
    Student deleteStudentById(Long studentId);
}

