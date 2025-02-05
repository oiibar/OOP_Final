package com.oop.OOP.services;

import com.oop.OOP.dto.ExamReportDto;
import com.oop.OOP.dto.UserScoreDto;
import com.oop.OOP.entities.Exam;
import com.oop.OOP.entities.Submission;
import com.oop.OOP.repo.SubmissionRepository;
import com.oop.OOP.repo.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ExamRepository examRepository;

    public ExamReportDto generateExamReport(Long examId) {
        Exam exam = examRepository.findById(examId).orElseThrow(() -> new RuntimeException("Exam not found"));

        List<Submission> submissions = submissionRepository.findByExam(exam);

        List<UserScoreDto> userScores = submissions.stream()
                .map(submission -> new UserScoreDto(submission.getCandidate().getName(), submission.getScore()))
                .collect(Collectors.toList());

        ExamReportDto reportDto = new ExamReportDto();
        reportDto.setExamTitle(exam.getTitle());
        reportDto.setNumberOfSubmissions(submissions.size());
        reportDto.setUserScores(userScores);

        return reportDto;
    }
}
