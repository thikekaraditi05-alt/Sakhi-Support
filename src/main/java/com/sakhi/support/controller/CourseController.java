package com.sakhi.support.controller;

import com.sakhi.support.dto.*;
import com.sakhi.support.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public CourseResponseDto createCourse(@Valid @RequestBody CourseRequestDto dto) {
        return courseService.createCourse(dto);
    }

    @GetMapping
    public List<CourseResponseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDetailResponseDto getCourseDetail(@PathVariable Long id) {
        return courseService.getCourseDetail(id);
    }

    @PostMapping("/modules")
    public ModuleResponseDto addModule(@Valid @RequestBody ModuleRequestDto dto) {
        return courseService.addModule(dto);
    }

    @PostMapping("/lessons")
    public LessonResponseDto addLesson(@Valid @RequestBody LessonRequestDto dto) {
        return courseService.addLesson(dto);
    }
}