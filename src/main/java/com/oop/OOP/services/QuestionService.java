package com.oop.OOP.services;

import com.oop.OOP.dto.QuestionDto;
import com.oop.OOP.entities.Question;
import com.oop.OOP.repo.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(QuestionDto questionDto) {
        Question question = new Question(
                questionDto.getText(),
                questionDto.getOptionA(),
                questionDto.getOptionB(),
                questionDto.getOptionC(),
                questionDto.getOptionD(),
                questionDto.getCorrectAnswer()
        );
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public Question updateQuestion(Long id, QuestionDto questionDto) {
        Question question = getQuestionById(id);
        question.setText(questionDto.getText());
        question.setOptionA(questionDto.getOptionA());
        question.setOptionB(questionDto.getOptionB());
        question.setOptionC(questionDto.getOptionC());
        question.setOptionD(questionDto.getOptionD());
        question.setCorrectAnswer(questionDto.getCorrectAnswer());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }
}


