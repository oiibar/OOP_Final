package com.oop.OOP.controllers;

import com.oop.OOP.dto.ExamDto;
import com.oop.OOP.entities.Exam;
import com.oop.OOP.services.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public Exam createExam(@RequestBody Exam examDto) {
        return examService.saveExam(examDto);
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return examService.getExamById(id);
    }

    @PutMapping("/{id}")
    public Exam updateExam(@PathVariable Long id, @RequestBody ExamDto examDto) {
        return examService.updateExam(id, examDto);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }
}


