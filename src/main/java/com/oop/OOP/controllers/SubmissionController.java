package com.oop.OOP.controllers;

import com.oop.OOP.dto.SubmissionDto;
import com.oop.OOP.entities.Submission;
import com.oop.OOP.services.SubmissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping
    public Submission submitExam(@RequestBody SubmissionDto submissionRequest) {
        return submissionService.submitExam(submissionRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteSubmission(@PathVariable Long id) {
        submissionService.deleteSubmissionById(id);
    }

    @GetMapping
    public List<Submission> getAllSubmissions() {
        return submissionService.getAllSubmissions();
    }

}
