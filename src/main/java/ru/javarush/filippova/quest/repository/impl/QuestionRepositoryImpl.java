package ru.javarush.filippova.quest.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.javarush.filippova.quest.domain.entity.Question;
import ru.javarush.filippova.quest.repository.QuestionRepository;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class QuestionRepositoryImpl implements QuestionRepository {

    public static File getResourceFile(String relativePath) {
        File file = null;
        URL location = QuestionRepositoryImpl.class.getProtectionDomain().getCodeSource().getLocation();
        String codeLocation = location.toString();
        try {
            if (codeLocation.endsWith(".jar")) {
                //Call from jar
                Path path = Paths.get(location.toURI()).resolve("../classes/" + relativePath).normalize();
                file = path.toFile();
            } else {
                //Call from IDE
                file = new File(QuestionRepositoryImpl.class.getClassLoader().getResource(relativePath).getFile());
            }
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        return file;
    }

    @Override
    public List<Question> getAllQuestions() {

        File file = getResourceFile("questionsListNew.json");
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
