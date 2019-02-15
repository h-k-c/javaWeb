package com.test.service.impl;

import com.test.mapper.AnswerMapper;
import com.test.pojo.Answer;
import com.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public void addanswer(Answer answer) {
        answer.setAnsDate(new Date());
        answerMapper.addanswer(answer);
    }
}
