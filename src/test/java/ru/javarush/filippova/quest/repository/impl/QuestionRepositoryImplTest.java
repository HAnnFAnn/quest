package ru.javarush.filippova.quest.repository.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import ru.javarush.filippova.quest.domain.entity.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionRepositoryImplTest {

    @Test
    void getQuestionById() throws JsonProcessingException {
        String jsonQuestion = "{" +
                "    \"id\" : 1," +
                "    \"text\" : \"test question\"," +
                "    \"imageLink\" : \"test link\"," +
                "    \"answers\" :" +
                "    [" +
                "      {" +
                "        \"id\" : 1," +
                "        \"text\" : \"test answer 1\"," +
                "        \"nextQuestionId\" : 2" +
                "      }," +
                "      {" +
                "        \"id\" : 2," +
                "        \"text\" : \"test answer 2\"," +
                "        \"nextQuestionId\" : 5" +
                "      }" +
                "    ]" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Question question =  objectMapper.readValue(jsonQuestion, Question.class);

        assertEquals(1, question.getId());
        assertEquals("test question", question.getText());
        assertEquals("test link", question.getImageLink());

        assertEquals(2, question.getAnswers().size());

        assertEquals(1, question.getAnswers().get(0).getId());
        assertEquals("test answer 1", question.getAnswers().get(0).getText());
        assertEquals(2, question.getAnswers().get(0).getNextQuestionId());

        assertEquals(2, question.getAnswers().get(1).getId());
        assertEquals("test answer 2", question.getAnswers().get(1).getText());
        assertEquals(5, question.getAnswers().get(1).getNextQuestionId());
    }
}