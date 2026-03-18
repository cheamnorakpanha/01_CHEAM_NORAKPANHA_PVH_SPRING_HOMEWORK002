package org.me._1_cheam_norakpanha_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.InstructorRequest;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
            @Result(property = "email", column = "email")
    })
    @Select("""
            SELECT * FROM instructors
            """)
    List<Instructor> getAllInstructors(Integer offset, Integer size);

    @ResultMap("instructorMapper")
    @Select("""
            SELECT * FROM instructors WHERE instructor_id = #{instructorId}
            """)
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
            INSERT INTO instructors VALUES (default, #{req.instructorName}, #{req.email}) RETURNING *
            """)
    Instructor createNewInstructor(@Param("req") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
            UPDATE instructors
            SET instructor_name = #{req.instructorName}, email = #{req.email}
            WHERE instructor_id = #{instructorId} RETURNING *
            """)
    Instructor updateInstructorById(Long instructorId, @Param("req") InstructorRequest request);

    @Delete("""
            DELETE FROM instructors WHERE instructor_id = #{instructorId} RETURNING *
            """)
    int deleteInstructorById(Long instructorId);
}
