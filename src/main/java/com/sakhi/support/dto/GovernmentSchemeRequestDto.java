package com.sakhi.support.dto;

import jakarta.validation.constraints.NotBlank;

public class GovernmentSchemeRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String eligibility;
    private String benefits;
    private String applyLink;
    private String category;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEligibility() { return eligibility; }
    public void setEligibility(String eligibility) { this.eligibility = eligibility; }

    public String getBenefits() { return benefits; }
    public void setBenefits(String benefits) { this.benefits = benefits; }

    public String getApplyLink() { return applyLink; }
    public void setApplyLink(String applyLink) { this.applyLink = applyLink; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}