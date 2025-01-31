package com.oop.OOP.services;

import com.oop.OOP.dto.CandidateDto;
import com.oop.OOP.entities.Candidate;
import com.oop.OOP.repo.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate registerCandidate(CandidateDto candidateDto) {
        Candidate candidate = new Candidate(candidateDto.getName(), candidateDto.getEmail());
        return candidateRepository.save(candidate);
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public Candidate updateCandidate(Long id, CandidateDto candidateDto) {
        Candidate candidate = getCandidateById(id);
        candidate.setName(candidateDto.getName());
        candidate.setEmail(candidateDto.getEmail());
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
}



