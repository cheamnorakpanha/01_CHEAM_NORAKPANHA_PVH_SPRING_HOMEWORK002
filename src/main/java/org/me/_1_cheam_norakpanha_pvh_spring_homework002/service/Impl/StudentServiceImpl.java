package org.me._1_cheam_norakpanha_pvh_spring_homework002.service.Impl;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Student;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.repository.StudentRepository;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents(Integer page, Integer size) {

        Integer offset = size * (page - 1);

        return studentRepository.getAllStudents(offset, size);
    }

    @Override
    public Student getStundentById(Long studentId) {
        return studentRepository.getStundentById(studentId);
    }
}
