package org.me._1_cheam_norakpanha_pvh_spring_homework002.service.Impl;

import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.InstructorRequest;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.repository.InstructorRepository;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {

        Integer offset = size * (page - 1);

        return instructorRepository.getAllInstructors(offset, size);
    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        return instructorRepository.getInstructorById(instructorId);
    }

    @Override
    public Instructor createNewInstructor(InstructorRequest request) {
        return instructorRepository.createNewInstructor(request);
    }

    @Override
    public Instructor updateInstructorById(Long instructorId, InstructorRequest request) {
        return instructorRepository.updateInstructorById(instructorId, request);
    }

    @Override
    public Instructor deleteInstructorById(Long instructorId) {
        Instructor instructor = instructorRepository.getInstructorById(instructorId);
        instructorRepository.deleteInstructorById(instructorId);

        return instructor;
    }
}
