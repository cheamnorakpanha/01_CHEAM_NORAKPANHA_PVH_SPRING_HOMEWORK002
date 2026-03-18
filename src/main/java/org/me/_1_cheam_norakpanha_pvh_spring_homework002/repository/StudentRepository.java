package org.me._1_cheam_norakpanha_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results(id = "studentMapper", value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number")
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
}
