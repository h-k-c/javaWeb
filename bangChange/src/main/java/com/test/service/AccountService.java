package com.test.service;


import com.test.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface AccountService {

    boolean existsCardNo(@Param("cardNo") String cardNo);

    Account login(@Param("account") Account account);

    double queryBalance(@Param("cardNo") String cardNo);

    Map<String, Object> transfer( Account account1,@Param("cardNo") String cardNo, @Param("transactionAmount") Double transactionAmount);

    boolean updatepassword(@Param("cardNo")String cardNo, @Param("resultpassword") String resultpassword);
}
