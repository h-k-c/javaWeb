package com.test.controller;


import com.test.constant.StatusUtil;
import com.test.pojo.Account;
import com.test.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Logger LOGGER=Logger.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;


    @RequestMapping("/login")
    public String login(Account account, Model model,HttpSession session){

        //假设前端验证通过
        boolean existCardNo=accountService.existsCardNo(account.getCardNo());
        if(existCardNo){
            //卡号密码登录
            Account account2=accountService.login(account);
            if(account2==null){
                //密码错误
                LOGGER.info("密码错误，开始执行。。。。");
                model.addAttribute("errorMsg","密码错误");
                return "index";
            }else{
                //检查状态
                if(account2.getStatus()==1){
                    //登陆成功
                    LOGGER.info("登录成功，开始执行。。。");
                    session.setAttribute("account",account2);
                    return "/jsp/main";
                }else{
                    //账号被冻结
                    LOGGER.info("账号冻结，开始执行。。。");
                    model.addAttribute("errorMsg","账号被冻结 ");
                }
            }
        }else{
            //卡号不存在错误
            LOGGER.info("账号不存在，开始执行。。。");
            model.addAttribute("errorMsg","账号不存在");
        }
        return "index";
    }

    @RequestMapping("/out")
    public String out(HttpSession session){
        session.removeAttribute("account");
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/balance")
    public String balance(@RequestParam("cardNo")String cardNo, Model model){

        double balance=accountService.queryBalance(cardNo);
        model.addAttribute("balance",balance);
        model.addAttribute("page","balance");
        return "/jsp/main";
    }

    @RequestMapping("/transferTo")
    public String transferTo(Model model){
        model.addAttribute("page","transferTo");
        return "/jsp/main";
    }

    @RequestMapping("/transfer")
    public String transfer(@RequestParam("cardNo")String cardNo,@RequestParam("transactionAmount")Double transactionAmount ,HttpSession session,Model model){

        Account account1= (Account) session.getAttribute("account");

        Map<String,Object> map= accountService.transfer(account1,cardNo,transactionAmount);

        int code= (int) map.get("code");
        model.addAttribute("code",code);
        String msg= (String) map.get("msg");
        model.addAttribute("msg",msg);
        model.addAttribute("page","transferTo");
        return "/jsp/main";
    }


    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("page","update");
        return "/jsp/main";
    }

    @RequestMapping("/updatepassword")
    public String updatePassword(Model model,@RequestParam("resultpassword")String resultpassword,HttpSession session){
        Account account= (Account) session.getAttribute("account");
        boolean result=accountService.updatepassword(account.getCardNo(),resultpassword);
        model.addAttribute("msg","操作成功");
        model.addAttribute("page","update");
        return "/jsp/main";
    }
}
