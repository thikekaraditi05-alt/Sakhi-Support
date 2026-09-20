package com.sakhi.support.dto;

public class DashboardStatsDto {

    private long totalUsers;
    private long totalCourses;
    private long totalJobs;
    private long totalSchemes;
    private long totalForumPosts;
    private long unresolvedMessages;

    public DashboardStatsDto() {}

    public DashboardStatsDto(long totalUsers, long totalCourses, long totalJobs,
                              long totalSchemes, long totalForumPosts, long unresolvedMessages) {
        this.totalUsers = totalUsers;
        this.totalCourses = totalCourses;
        this.totalJobs = totalJobs;
        this.totalSchemes = totalSchemes;
        this.totalForumPosts = totalForumPosts;
        this.unresolvedMessages = unresolvedMessages;
    }

    public long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(long totalUsers) { this.totalUsers = totalUsers; }

    public long getTotalCourses() { return totalCourses; }
    public void setTotalCourses(long totalCourses) { this.totalCourses = totalCourses; }

    public long getTotalJobs() { return totalJobs; }
    public void setTotalJobs(long totalJobs) { this.totalJobs = totalJobs; }

    public long getTotalSchemes() { return totalSchemes; }
    public void setTotalSchemes(long totalSchemes) { this.totalSchemes = totalSchemes; }

    public long getTotalForumPosts() { return totalForumPosts; }
    public void setTotalForumPosts(long totalForumPosts) { this.totalForumPosts = totalForumPosts; }

    public long getUnresolvedMessages() { return unresolvedMessages; }
    public void setUnresolvedMessages(long unresolvedMessages) { this.unresolvedMessages = unresolvedMessages; }
}