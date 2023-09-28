package ru.javarush.filippova.quest.service;

import ru.javarush.filippova.quest.domain.entity.Question;
import ru.javarush.filippova.quest.repository.impl.QuestionRepositoryImpl;

public class QuestionService {

    QuestionRepositoryImpl questionRepository = new QuestionRepositoryImpl();

    public Question getQuestionById(Long id) {
        return questionRepository.getQuestionById(id);
    }
}
