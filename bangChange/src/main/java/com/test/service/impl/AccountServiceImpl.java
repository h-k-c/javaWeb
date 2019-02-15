package com.test.service.impl;

import com.test.constant.StatusUtil;
import com.test.mapper.AccountMapper;
import com.test.mapper.TransactionRecordMapper;
import com.test.pojo.Account;
import com.test.pojo.TransactionRecord;
import com.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    TransactionRecordMapper transactionRecordMapper;

    @Override
    public boolean existsCardNo(String cardNo) {
        int count=accountMapper.existsCardNo(cardNo);
        return count==1 ? true:false;
    }

    @Override
    public Account login(Account account) {
        Account account1=accountMapper.queryByCardNoPwd(account.getCardNo(),account.getPassword());
        return account1;
    }

    @Override
    public double queryBalance(String cardNo) {

        double balance=accountMapper.querybalance(cardNo);
        return balance;
    }

    @Override
    public Map<String, Object> transfer(Account account1, String cardNo, Double transactionAmount) {
       Map<String,Object> map=new HashMap<>();
       int code= StatusUtil.NOT_EXISTS;
        //检查目标账号是否存在
        String msg=null;
        int row=accountMapper.existsCardNo(cardNo);
        if(row==1){
            //账号存在
            code=StatusUtil.EXISTS;

            //检查是否被冻结
            row= accountMapper.freeZon(cardNo);
            if(row==1){
                //激活

                //检查余额是否足够
                row=accountMapper.balanceEnough(account1.getCardNo(),transactionAmount);
                if(row==1){
                    //余额够转钱

                    //目标账号价钱
                    accountMapper.plusmoney(cardNo,transactionAmount);
                    //目前的账号减钱
                    accountMapper.minusmoney(account1.getCardNo(),transactionAmount);

                    //产生交易记录
                    TransactionRecord transactionRecord=new TransactionRecord();
                    transactionRecord.setCardNo(account1.getCardNo());
                    transactionRecord.setTransactionAmount(transactionAmount);
                    transactionRecord.setTransactionType("转账");
                    transactionRecord.setTransactionDate(new Date());
                    //重新查询balance
                    double balance=accountMapper.querybalance(account1.getCardNo());
                    transactionRecord.setBalance(balance);
                    transactionRecordMapper.insert(transactionRecord);

                    code=StatusUtil.SUCCESS;
                    msg=StatusUtil.SUCCESS_MSG;
                }else {

                    //余额不足
                    code=StatusUtil.NOT_ENOUGH;

                    msg=StatusUtil.NOT_ENOUGH_MSG;
                }
            }else{
                //冻结
                code=StatusUtil.NOT_FREEZON;

                msg=StatusUtil.NOT_FREEZON_MSG;
            }
        }else{
            //目标账号不存在，默认赋值不存在，无需处理
            msg=StatusUtil.NOT_EXISTS_MSG;
        }
        map.put("code",code);

        map.put("msg",msg);

        return map;
    }

    @Override
    public boolean updatepassword(String cardNo, String resultpassword) {

        return accountMapper.updatepassword(cardNo,resultpassword);
    }
}
