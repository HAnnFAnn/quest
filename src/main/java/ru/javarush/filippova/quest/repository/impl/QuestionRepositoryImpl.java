package ru.javarush.filippova.quest.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.filippova.quest.domain.entity.Question;
import ru.javarush.filippova.quest.repository.QuestionRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class QuestionRepositoryImpl implements QuestionRepository {
    File file = new File("/src/main/resources/questionsList.json");
    //File file = new File("/Users/hann/JavaProj/ru.javarush.filippova.quest/src/main/resources/questionsList.json");
    @Override
    public List<Question> getAllQuestions() {

        List<Question> questions = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            questions = objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Question.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public Question getQuestionById(Long id) {
        return getAllQuestions()
                    .stream()
                    .filter(it -> Objects.equals(it.getId(), id))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
    }
}
