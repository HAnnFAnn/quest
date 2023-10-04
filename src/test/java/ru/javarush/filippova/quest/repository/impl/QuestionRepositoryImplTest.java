package ru.javarush.filippova.quest.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.javarush.filippova.quest.domain.entity.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionRepositoryImplTest {

    private QuestionRepositoryImpl questionRepository;

    @BeforeEach
    public void setup() {
        questionRepository = new QuestionRepositoryImpl();
    }

    @Test
    public void testGetAllQuestions() {
        List<Question> questions = questionRepository.getAllQuestions();

        assertNotNull(questions);

        for (Question question : questions) {
            assertNotNull(question.getId());
            assertNotNull(question.getText());
            assertNotNull(question.getAnswers());
        }
    }

    @Test
    void returnQuestionWhenGetById() throws JsonProcessingException {
        String expectedJsonQuestion = "{\n    \"id\": 2,\n    \"text\": \"Ты принял вызов.<br>Что выбираешь?\",\n    \"imageLink\": \"image/question_2.png\",\n    \"answers\":[\n      {\n        \"id\": 3,\n        \"text\": \"Отведать развесистой клюквы\",\n        \"nextQuestionId\": 4\n      },\n      {\n        \"id\": 4,\n        \"text\": \"Сварить кашу из топора\",\n        \"nextQuestionId\": 3\n      }\n    ]\n  }";

        ObjectMapper objectMapper = new ObjectMapper();
        Question expectedQuestion = objectMapper.readValue(expectedJsonQuestion, Question.class);

        Question actualQuestion = questionRepository.getQuestionById(2L);

        assertEquals(expectedQuestion, actualQuestion);
    }
}