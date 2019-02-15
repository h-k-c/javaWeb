package com.test.controller;


import com.test.pojo.Answer;
import com.test.pojo.Question;
import com.test.service.AnswerService;
import com.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;


    @RequestMapping("/put")
    public String put(){
        return "question";
    }

    @RequestMapping("/save")
    public String save(Question question){
        questionService.save(question);
        return "redirect:/";
    }

    @RequestMapping("/answer")
    public String answer(@RequestParam("id")Integer id, Model model){
        Question result=questionService.queryOwn(id);
        if(result.getAnswerCount()==0){
            model.addAttribute("question",result);
        }else {
            Question list=questionService.queryanswer(result.getId());
            model.addAttribute("question",list);
        }
        return "answer";
    }

    @RequestMapping("/ask")
    public String ask(Answer answer,Model model){
        questionService.update(answer.getQid());
        answerService.addanswer(answer);
        return "redirect:/";
    }

}
