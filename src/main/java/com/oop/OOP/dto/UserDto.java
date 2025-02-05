package com.oop.OOP.dto;

import com.oop.OOP.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String password;
    private Role role;
}

