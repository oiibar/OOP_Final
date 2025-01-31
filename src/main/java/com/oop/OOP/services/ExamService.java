package com.oop.OOP.services;

import com.oop.OOP.dto.ExamDto;
import com.oop.OOP.entities.Exam;
import com.oop.OOP.repo.ExamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public List<Exam> getUpcomingExams() {
        return examRepository.findByExamDateAfter(LocalDateTime.now());
    }

    public Exam createExam(ExamDto examDto) {
        Exam exam = new Exam(examDto.getTitle(), examDto.getScore());
        return examRepository.save(exam);
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    public Exam updateExam(Long id, ExamDto examDto) {
        Exam exam = getExamById(id);
        exam.setTitle(examDto.getTitle());
        exam.setScore(examDto.getScore());
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }
}


