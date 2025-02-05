package com.oop.OOP.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    @JsonBackReference("exam-questions")
    private Exam exam;

    private String text;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    public Question(String text, String optionA, String optionB, String optionC, String optionD, String correctAnswer) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrectAnswer(String userAnswer) {
        switch (userAnswer.toUpperCase()) {
            case "A":
                return this.correctAnswer.equalsIgnoreCase(this.optionA);
            case "B":
                return this.correctAnswer.equalsIgnoreCase(this.optionB);
            case "C":
                return this.correctAnswer.equalsIgnoreCase(this.optionC);
            case "D":
                return this.correctAnswer.equalsIgnoreCase(this.optionD);
            default:
                return false;
        }
    }

}
