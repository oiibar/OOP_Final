package com.oop.OOP.dto;

import com.oop.OOP.entities.Question;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExamDto {
    private String title;
    private List<Question> questions;
}

