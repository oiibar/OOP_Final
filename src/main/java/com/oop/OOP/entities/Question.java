package com.oop.OOP.entities;
import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    private String answer;

    private String[] options;

    public Question(int id, String question, String answer, String[] options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }
}

