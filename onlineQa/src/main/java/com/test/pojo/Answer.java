package com.test.pojo;

import java.util.Date;

public class Answer {

    private Integer id;

    private String ansContext;

    public String getAnsContext() {
        return ansContext;
    }

    public void setAnsContext(String ansContext) {
        this.ansContext = ansContext;
    }

    private Date ansDate;

    private Integer qid;

    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Date getAnsDate() {
        return ansDate;
    }

    public void setAnsDate(Date ansDate) {
        this.ansDate = ansDate;
    }

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }
}
