package ru.javarush.filippova.quest.repository;

import ru.javarush.filippova.quest.domain.entity.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionRepository {
    List<Question> getAllQuestions() throws IOException;

    Question getQuestionById(Long id) throws Exception;
}
