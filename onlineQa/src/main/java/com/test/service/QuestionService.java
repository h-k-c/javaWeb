package com.test.service;

import com.test.pojo.Answer;
import com.test.pojo.Question;

import java.util.List;

public interface QuestionService {

    List<Question> queryAll();

    void save(Question question);

    Question queryanswer(Integer id);

    void update(Integer qid);

    Question queryOwn(Integer id);
}
