package com.oop.OOP.services;

import com.oop.OOP.dto.AdminDto;
import com.oop.OOP.entities.Admin;
import com.oop.OOP.repo.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin saveAdmin(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getUsername(), adminDto.getPassword());
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public Admin updateAdmin(Long id, AdminDto adminDto) {
        Admin admin = getAdminById(id);
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}


