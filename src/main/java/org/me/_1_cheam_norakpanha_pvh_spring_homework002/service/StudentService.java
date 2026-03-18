package org.me._1_cheam_norakpanha_pvh_spring_homework002.service;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents(Integer page, Integer size);

    Student getStundentById(Long studentId);
}
