package ru.javarush.filippova.quest.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Question {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("imageLink")
    private String imageLink;
    @JsonProperty("answers")
    private List<Answer> answers;
}
