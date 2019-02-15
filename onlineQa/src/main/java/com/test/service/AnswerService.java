package com.test.service;

import com.test.pojo.Answer;
import org.apache.ibatis.annotations.Param;

public interface AnswerService {
    void addanswer(Answer answer);
}
