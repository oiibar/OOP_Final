package com.oop.OOP.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ExamReportDto {
    private String examTitle;
    private int numberOfSubmissions;
    private List<UserScoreDto> userScores;
}
