package com.sakhi.support.service;

import com.sakhi.support.dto.*;
import com.sakhi.support.model.Course;
import com.sakhi.support.model.CourseModule;
import com.sakhi.support.model.Lesson;
import com.sakhi.support.repository.CourseModuleRepository;
import com.sakhi.support.repository.CourseRepository;
import com.sakhi.support.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseModuleRepository courseModuleRepository;

    @Autowired
    private LessonRepository lessonRepository;

    // Create a new course (Admin)
    public CourseResponseDto createCourse(CourseRequestDto dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCategory(dto.getCategory());
        course.setThumbnailUrl(dto.getThumbnailUrl());

        Course saved = courseRepository.save(course);

        return toCourseResponseDto(saved);
    }

    // Get all courses (simple list, for course catalog page)
    public List<CourseResponseDto> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(this::toCourseResponseDto)
                .collect(Collectors.toList());
    }

    // Get one course with full nested modules + lessons (for course detail page)
    public CourseDetailResponseDto getCourseDetail(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        List<CourseModule> modules = courseModuleRepository
                .findByCourseIdOrderByOrderIndexAsc(courseId);

        List<ModuleResponseDto> moduleDtos = modules.stream()
                .map(module -> {
                    List<Lesson> lessons = lessonRepository
                            .findByModuleIdOrderByOrderIndexAsc(module.getId());

                    List<LessonResponseDto> lessonDtos = lessons.stream()
                            .map(lesson -> new LessonResponseDto(
                                    lesson.getId(),
                                    lesson.getTitle(),
                                    lesson.getVideoUrl(),
                                    lesson.getContent(),
                                    lesson.getOrderIndex(),
                                    lesson.getDurationMinutes()
                            ))
                            .collect(Collectors.toList());

                    return new ModuleResponseDto(
                            module.getId(),
                            module.getTitle(),
                            module.getOrderIndex(),
                            lessonDtos
                    );
                })
                .collect(Collectors.toList());

        return new CourseDetailResponseDto(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getCategory(),
                course.getThumbnailUrl(),
                moduleDtos
        );
    }

    // Add a module to a course (Admin)
    public ModuleResponseDto addModule(ModuleRequestDto dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        CourseModule module = new CourseModule();
        module.setCourse(course);
        module.setTitle(dto.getTitle());
        module.setOrderIndex(dto.getOrderIndex());

        CourseModule saved = courseModuleRepository.save(module);

        return new ModuleResponseDto(
                saved.getId(),
                saved.getTitle(),
                saved.getOrderIndex(),
                List.of()
        );
    }

    // Add a lesson to a module (Admin)
    public LessonResponseDto addLesson(LessonRequestDto dto) {
        CourseModule module = courseModuleRepository.findById(dto.getModuleId())
                .orElseThrow(() -> new RuntimeException("Module not found"));

        Lesson lesson = new Lesson();
        lesson.setModule(module);
        lesson.setTitle(dto.getTitle());
        lesson.setVideoUrl(dto.getVideoUrl());
        lesson.setContent(dto.getContent());
        lesson.setOrderIndex(dto.getOrderIndex());
        lesson.setDurationMinutes(dto.getDurationMinutes());

        Lesson saved = lessonRepository.save(lesson);

        return new LessonResponseDto(
                saved.getId(),
                saved.getTitle(),
                saved.getVideoUrl(),
                saved.getContent(),
                saved.getOrderIndex(),
                saved.getDurationMinutes()
        );
    }

    private CourseResponseDto toCourseResponseDto(Course course) {
        return new CourseResponseDto(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getCategory(),
                course.getThumbnailUrl()
        );
    }
}