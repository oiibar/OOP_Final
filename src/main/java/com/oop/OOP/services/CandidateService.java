package com.oop.OOP.services;

import com.oop.OOP.entities.Candidate;
import com.oop.OOP.repo.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(int id) {
        return candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(int id, Candidate updatedCandidate) {
        Candidate candidate = getCandidateById(id);
        candidate.setName(updatedCandidate.getName());
        candidate.setScore(updatedCandidate.getScore());
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(int id) {
        candidateRepository.deleteById(id);
    }
}

