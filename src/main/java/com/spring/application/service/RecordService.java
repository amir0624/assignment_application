package com.spring.application.service;

import com.spring.application.model.DataRecord;

import java.util.List;

public interface RecordService {
    DataRecord createRecord(Record record);
    DataRecord getRecordById(Long id);

    List<DataRecord> getAllRecords();

    DataRecord updateRecord(Long id, DataRecord updatedRecord);

    void deleteRecord(Long id);
}
