package com.oop.OOP.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubmissionDto {
    private Long userId;
    private Long examId;
    private List<String> answers;
}
