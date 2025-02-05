package com.oop.OOP.services;

import com.oop.OOP.dto.ExamDto;
import com.oop.OOP.entities.Exam;
import com.oop.OOP.repo.ExamRepository;
import com.oop.OOP.repo.QuestionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;

    public ExamService(ExamRepository examRepository, QuestionRepository questionRepository) {
        this.examRepository = examRepository;
        this.questionRepository = questionRepository;
    }

    public Exam saveExam(Exam exam) {
        Exam savedExam = examRepository.save(exam);

        if (exam.getQuestions() != null) {
            exam.getQuestions().forEach(question -> {
                question.setExam(savedExam);
            });
            questionRepository.saveAll(exam.getQuestions());
        }

        return savedExam;
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam not found"));
    }

    public Exam updateExam(Long id, ExamDto examDto) {
        Exam exam = getExamById(id);
        exam.setTitle(examDto.getTitle());
        return examRepository.save(exam);
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }
}


