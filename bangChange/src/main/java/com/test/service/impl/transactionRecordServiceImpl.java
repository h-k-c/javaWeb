package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dto.RecordDTO;
import com.test.mapper.TransactionRecordMapper;
import com.test.pojo.TransactionRecord;
import com.test.service.TransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class transactionRecordServiceImpl implements TransactionRecordService {

    @Autowired
    private TransactionRecordMapper transactionRecordMapper;

    @Override
    public PageInfo<TransactionRecord> queryRecord(RecordDTO recordDTO) {
        PageHelper.startPage(recordDTO.getPageNum(),recordDTO.getPageSize());
        List<TransactionRecord> l=transactionRecordMapper.queryRecord(recordDTO);
        PageInfo<TransactionRecord> page=new PageInfo<>(l);
        return page;
    }
}
