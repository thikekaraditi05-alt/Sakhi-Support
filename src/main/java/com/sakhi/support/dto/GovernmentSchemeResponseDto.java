package com.sakhi.support.dto;

public class GovernmentSchemeResponseDto {

    private Long id;
    private String title;
    private String description;
    private String eligibility;
    private String benefits;
    private String applyLink;
    private String category;

    public GovernmentSchemeResponseDto() {}

    public GovernmentSchemeResponseDto(Long id, String title, String description, String eligibility,
                                        String benefits, String applyLink, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.eligibility = eligibility;
        this.benefits = benefits;
        this.applyLink = applyLink;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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