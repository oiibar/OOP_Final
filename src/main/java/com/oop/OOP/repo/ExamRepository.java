package com.oop.OOP.repo;

import com.oop.OOP.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByExamDateAfter(LocalDateTime now);
}

