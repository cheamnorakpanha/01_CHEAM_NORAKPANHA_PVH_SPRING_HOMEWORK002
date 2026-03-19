package org.me._1_cheam_norakpanha_pvh_spring_homework002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Student;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.StudentRequest;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.response.ApiResponse;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {

        List<Student> students = studentService.getAllStudents(page, size);

        ApiResponse<List<Student>> response = ApiResponse.<List<Student>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students retrieved successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable("student-id") Long studentId) {

        Student students = studentService.getStundentById(studentId);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Student fetched successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Create a new student")
    @PostMapping
    public ResponseEntity<ApiResponse<Student>> createNewStudent(@RequestBody StudentRequest request) {

        Student students = studentService.createNewStudent(request);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("Students created successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update student by ID")
    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> updateStudentById(@PathVariable("student-id") Long studentId, @RequestBody StudentRequest request) {

        Student students = studentService.updateStudentById(studentId, request);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students updated successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable("student-id") Long studentId) {

        Student students = studentService.deleteStudentById(studentId);

        ApiResponse<Student> response = ApiResponse.<Student>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Students deleted successfully")
                .payload(students)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
