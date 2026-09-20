package com.sakhi.support.controller;

import com.sakhi.support.dto.DashboardStatsDto;
import com.sakhi.support.model.User;
import com.sakhi.support.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/stats")
    public DashboardStatsDto getStats() {
        return adminService.getStats();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}/deactivate")
    public String deactivateUser(@PathVariable Long id) {
        adminService.deactivateUser(id);
        return "User deactivated successfully";
    }

    @PutMapping("/contact/{id}/resolve")
    public String resolveContactMessage(@PathVariable Long id) {
        adminService.resolveContactMessage(id);
        return "Message marked as resolved";
    }
}