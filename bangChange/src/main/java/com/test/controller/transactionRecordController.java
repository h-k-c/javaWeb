package com.test.controller;


import com.github.pagehelper.PageInfo;
import com.test.dto.RecordDTO;
import com.test.pojo.Account;
import com.test.pojo.TransactionRecord;
import com.test.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/transactionRecord")
public class transactionRecordController {

    @Autowired
    private TransactionRecordService transactionRecordService;

    @RequestMapping("/query")
    public String query(RecordDTO recordDTO,Model model){
        PageInfo<TransactionRecord> page=transactionRecordService.queryRecord(recordDTO);
        model.addAttribute("page","record");
        model.addAttribute("pageInfo",page);
        return "/jsp/main";
    }

    @RequestMapping("/index")
    public String records( Model model){

        model.addAttribute("page","record");
        return "/jsp/main";
    }


}
