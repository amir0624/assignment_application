package com.spring.application.service;

import com.spring.application.model.DataRecord;
import com.spring.application.repository.DataRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataRecordService {
    @Autowired
    private DataRecordRepository dataRecordRepository;

    public DataRecord createDataRecord(DataRecord dataRecord) {
        return dataRecordRepository.save(dataRecord);
    }

    public DataRecord getDataRecordById(Long id) {
        return dataRecordRepository.findById(id).orElse(null);
    }

    public DataRecord updateDataRecord(Long id, DataRecord dataRecord) {
        DataRecord existingDataRecord = dataRecordRepository.findById(id).orElse(null);
        if (existingDataRecord != null) {
            existingDataRecord.setName(dataRecord.getName());
            existingDataRecord.setEmail(dataRecord.getEmail());
            existingDataRecord.setAge(dataRecord.getAge());
            return dataRecordRepository.save(existingDataRecord);
        }
        return null;
    }

    public void deleteDataRecord(Long id) {
        dataRecordRepository.deleteById(id);
    }
}
