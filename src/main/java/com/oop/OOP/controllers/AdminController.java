package com.oop.OOP.controllers;

import com.oop.OOP.dto.AdminDto;
import com.oop.OOP.entities.Admin;
import com.oop.OOP.services.AdminService;
import org.springframework.web.bind.annotation.*;


import lombok.Data;

@Data
@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Admin createAdmin(@RequestBody AdminDto adminDto) {
        return adminService.saveAdmin(adminDto);
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody AdminDto adminDto) {
        return adminService.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}



