package com.test.mapper;


import com.github.pagehelper.PageInfo;
import com.test.dto.RecordDTO;
import com.test.pojo.TransactionRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface TransactionRecordMapper {

    void insert(TransactionRecord transactionRecord);

    List<TransactionRecord> queryRecord(RecordDTO recordDTO);
}
