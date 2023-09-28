package ru.javarush.filippova.quest.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("text")
    private String text;
    @JsonProperty("nextQuestionId")
    private Long nextQuestionId;

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Long getNextQuestionId() {
        return nextQuestionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", nextQuestionId=" + nextQuestionId +
                '}';
    }
}
