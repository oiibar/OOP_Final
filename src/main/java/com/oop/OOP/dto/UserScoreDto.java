package com.oop.OOP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserScoreDto {
    private String name;
    private int score;
}
