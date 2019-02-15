package com.test.service.impl;

import com.test.mapper.QuestionMapper;
import com.test.pojo.Answer;
import com.test.pojo.Question;
import com.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> queryAll() {
        return questionMapper.queryAll();
    }

    @Override
    public void save(Question question) {
        question.setLastModified(new Date());
        questionMapper.save(question);
    }

    @Override
    public Question queryanswer(Integer id) {

        return questionMapper.queryanswer(id);
    }

    @Override
    public void update(Integer qid) {
        questionMapper.update(qid);
    }

    @Override
    public Question queryOwn(Integer id) {

        return questionMapper.queryOwn(id);
    }
}
