package org.me._1_cheam_norakpanha_pvh_spring_homework002.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.entity.Course;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.request.CourseRequest;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.model.response.ApiResponse;
import org.me._1_cheam_norakpanha_pvh_spring_homework002.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Get all courses")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Course>>> getAllCourses(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer size) {

        List<Course> courses = courseService.getAllCourses(page, size);

        ApiResponse<List<Course>> response = ApiResponse.<List<Course>>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses retrieved successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Get course by ID")
    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> getCourseById(@PathVariable("course-id") Long courseId) {

        Course courses = courseService.getCourseById(courseId);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses fetched successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Create a new course")
    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createNewCourse(@RequestBody CourseRequest request) {

        Course courses = courseService.createNewCourse(request);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.CREATED.value())
                .message("Courses created successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update course by ID")
    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> updateCourseById(@PathVariable("course-id") Long courseId, @RequestBody CourseRequest request) {

        Course courses = courseService.updateCourseById(courseId, request);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses updated successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "Delete course by ID")
    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Course>> deleteCourseById(@PathVariable("course-id") Long courseId) {

        Course courses = courseService.deleteCourseById(courseId);

        ApiResponse<Course> response = ApiResponse.<Course>builder()
                .success(true)
                .status(HttpStatus.OK.value())
                .message("Courses deleted successfully")
                .payload(courses)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
