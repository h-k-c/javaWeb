package com.test.service;


import com.github.pagehelper.PageInfo;
import com.test.dto.RecordDTO;
import com.test.pojo.TransactionRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionRecordService {


    PageInfo<TransactionRecord> queryRecord(RecordDTO recordDTO);

}
