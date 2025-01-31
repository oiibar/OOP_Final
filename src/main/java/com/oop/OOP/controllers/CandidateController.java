package com.oop.OOP.controllers;

import com.oop.OOP.dto.CandidateDto;
import com.oop.OOP.entities.Candidate;
import com.oop.OOP.services.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public Candidate registerCandidate(@RequestBody CandidateDto candidateDto) {
        return candidateService.registerCandidate(candidateDto);
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id, @RequestBody CandidateDto candidateDto) {
        return candidateService.updateCandidate(id, candidateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }
}

