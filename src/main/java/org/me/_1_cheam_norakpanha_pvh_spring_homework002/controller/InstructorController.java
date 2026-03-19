package org.me._1_cheam_norakpanha_pvh_spring_homework002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Instructor;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.InstructorRequest;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.response.ApiResponse;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Operation(summary = "Get all instructors")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {

        List<Instructor> instructors = instructorService.getAllInstructors(page, size);

        ApiResponse<List<Instructor>> response = ApiResponse.<List<Instructor>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Instructors retrieved successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Get instructor by ID")
    @GetMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable("instructor-id") Long instructorId) {

        Instructor instructors = instructorService.getInstructorById(instructorId);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Instructors fetched successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Create a new instructor")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createNewInstructor(@RequestBody InstructorRequest request) {

        Instructor instructors = instructorService.createNewInstructor(request);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("Instructors created successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update instructor by ID")
    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor-id") Long instructorId, @RequestBody InstructorRequest request) {

        Instructor instructors = instructorService.updateInstructorById(instructorId, request);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Instructors updated successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete instructor by ID")
    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Long instructorId) {

        Instructor instructors = instructorService.deleteInstructorById(instructorId);

        ApiResponse<Instructor> response = ApiResponse.<Instructor>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Instructors deleted successfully")
                .payload(instructors)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
