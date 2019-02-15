package com.test.controller;

import com.test.pojo.Question;
import com.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(Model model){
        List<Question> list=questionService.queryAll();
        model.addAttribute("questions",list);
        return "main";
    }
}
