package com.revision.helper.model;

import java.util.List;

public class RevisionResponse {

    private List<Question> questions;

    public RevisionResponse(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
