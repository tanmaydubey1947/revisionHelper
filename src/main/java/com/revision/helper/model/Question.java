package com.revision.helper.model;

import java.util.List;


public class Question {

    private String questionName;
    private String description;
    private String source;
    private List<String> tags;

    public Question() {
    }

    public Question(String questionName, String description, String source, List<String> tags) {
        this.questionName = questionName;
        this.description = description;
        this.source = source;
        this.tags = tags;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
