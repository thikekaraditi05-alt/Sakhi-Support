package com.sakhi.support.dto;

import java.util.List;

public class ModuleResponseDto {

    private Long id;
    private String title;
    private Integer orderIndex;
    private List<LessonResponseDto> lessons;

    public ModuleResponseDto() {}

    public ModuleResponseDto(Long id, String title, Integer orderIndex, List<LessonResponseDto> lessons) {
        this.id = id;
        this.title = title;
        this.orderIndex = orderIndex;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public List<LessonResponseDto> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonResponseDto> lessons) {
        this.lessons = lessons;
    }
}