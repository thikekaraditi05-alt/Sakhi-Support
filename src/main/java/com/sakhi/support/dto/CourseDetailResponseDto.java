package com.sakhi.support.dto;

import java.util.List;

public class CourseDetailResponseDto {

    private Long id;
    private String title;
    private String description;
    private String category;
    private String thumbnailUrl;
    private List<ModuleResponseDto> modules;

    public CourseDetailResponseDto() {}

    public CourseDetailResponseDto(Long id, String title, String description, String category,
                                    String thumbnailUrl, List<ModuleResponseDto> modules) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.thumbnailUrl = thumbnailUrl;
        this.modules = modules;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public List<ModuleResponseDto> getModules() {
        return modules;
    }

    public void setModules(List<ModuleResponseDto> modules) {
        this.modules = modules;
    }
}