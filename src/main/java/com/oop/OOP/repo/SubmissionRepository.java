package com.oop.OOP.repo;

import com.oop.OOP.entities.Exam;
import com.oop.OOP.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByExam(Exam exam);
}
