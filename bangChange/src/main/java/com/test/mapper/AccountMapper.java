package com.test.mapper;

import com.test.pojo.Account;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    /**
     * @param cardNo
     * @return
     */
    int existsCardNo(@Param("cardNo") String cardNo);

    Account queryByCardNoPwd(@Param("cardNo") String cardNo, @Param("password") String password);

    double querybalance(@Param("cardNo") String cardNo);

    int freeZon(@Param("cardNo") String cardNo);

    int balanceEnough(@Param("cardNo") String cardNo, @Param("transactionAmount") Double t);

    void plusmoney(@Param("cardNo") String cardNo, @Param("transactionAmount")Double t);

    void minusmoney(@Param("cardNo") String cardNo, @Param("transactionAmount")Double t);

    boolean updatepassword(@Param("cardNo")String cardNo, @Param("resultpassword")String resultpassword);
}
