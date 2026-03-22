package org.me._1_cheam_norakpanha_pvh_spring_homework002.service;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.InstructorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstructorService {

    List<Instructor> getAllInstructors(Integer page, Integer size);

    Instructor getInstructorById(Long instructorId);

    Instructor createNewInstructor(InstructorRequest request);

    Instructor updateInstructorById(Long instructorId, InstructorRequest request);

    void deleteInstructorById(Long instructorId);
}
