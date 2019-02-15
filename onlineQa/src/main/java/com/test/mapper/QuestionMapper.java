package com.test.mapper;

import com.test.pojo.Answer;
import com.test.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    List<Question> queryAll();

    void save(Question question);

    Question queryanswer(Integer id);

    void update(Integer qid);

    Question queryOwn(@Param("id") Integer id);
}
