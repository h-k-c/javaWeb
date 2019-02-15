package com.test.mapper;

import com.test.pojo.Answer;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper {
    void addanswer(Answer answer);
}
