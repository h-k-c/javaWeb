package com.test.pojo;

import java.util.List;

public class Account {

    private Long id;

    private String cardNo;

    private String password;

    private String balance;

    private Integer status;

    private List<TransactionRecord> TransactionRecords;

    public List<TransactionRecord> getTransactionRecords() {
        return TransactionRecords;
    }

    public void setTransactionRecords(List<TransactionRecord> TransactionRecords) {
        this.TransactionRecords = TransactionRecords;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
