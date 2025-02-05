package com.oop.OOP.services;

import com.oop.OOP.dto.SubmissionDto;
import com.oop.OOP.entities.Exam;
import com.oop.OOP.entities.Question;
import com.oop.OOP.entities.Submission;
import com.oop.OOP.entities.User;
import com.oop.OOP.repo.ExamRepository;
import com.oop.OOP.repo.SubmissionRepository;
import com.oop.OOP.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class SubmissionService {

    private final ExamRepository examRepository;
    private final UserRepository userRepository;
    private final SubmissionRepository submissionRepository;

    public SubmissionService(ExamRepository examRepository,
                             UserRepository userRepository,
                             SubmissionRepository submissionRepository) {
        this.examRepository = examRepository;
        this.userRepository = userRepository;
        this.submissionRepository = submissionRepository;
    }

    public Submission submitExam(SubmissionDto submissionRequest) {
        User candidate = userRepository.findById(submissionRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Exam exam = examRepository.findById(submissionRequest.getExamId())
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        int score = calculateScore(exam, submissionRequest.getAnswers());

        Submission submission = new Submission();
        submission.setCandidate(candidate);
        submission.setExam(exam);
        submission.setScore(score);
        submission.setSubmissionTime(LocalDateTime.now().toString());

        return submissionRepository.save(submission);
    }

    private int calculateScore(Exam exam, List<String> candidateAnswers) {
        int score = 0;
        List<Question> questions = exam.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);

            if (i < candidateAnswers.size()) {
                String userAnswer = candidateAnswers.get(i);

                if (question.isCorrectAnswer(userAnswer)) {
                    score++;
                }
            }
        }
        return score;
    }

    public List<Submission> getAllSubmissions() {
        return submissionRepository.findAll();
    }

    public void deleteSubmissionById(Long id) {
        submissionRepository.deleteById(id);
    }



}
