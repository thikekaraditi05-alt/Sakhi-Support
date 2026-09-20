package com.sakhi.support.dto;

public class JobListingResponseDto {

    private Long id;
    private String title;
    private String companyName;
    private String description;
    private String location;
    private String type;
    private String applyLink;
    private String salaryRange;

    public JobListingResponseDto() {}

    public JobListingResponseDto(Long id, String title, String companyName, String description,
                                  String location, String type, String applyLink, String salaryRange) {
        this.id = id;
        this.title = title;
        this.companyName = companyName;
        this.description = description;
        this.location = location;
        this.type = type;
        this.applyLink = applyLink;
        this.salaryRange = salaryRange;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getApplyLink() { return applyLink; }
    public void setApplyLink(String applyLink) { this.applyLink = applyLink; }

    public String getSalaryRange() { return salaryRange; }
    public void setSalaryRange(String salaryRange) { this.salaryRange = salaryRange; }
}