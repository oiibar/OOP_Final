package com.oop.OOP.controllers;

import com.oop.OOP.dto.ExamReportDto;
import com.oop.OOP.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exams")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("{examId}/report")
    public ExamReportDto getExamReport(@PathVariable Long examId) {
        return reportService.generateExamReport(examId);
    }
}
