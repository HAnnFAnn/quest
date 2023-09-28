package ru.javarush.filippova.quest.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Question {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("imageLink")
    private String imageLink;
    @JsonProperty("answers")
    private List<Answer> answers;

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getImageLink() {
        return imageLink;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", answers=" + answers +
                '}';
    }
}
