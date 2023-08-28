package com.spring.application.controller;

import com.spring.application.model.DataRecord;
import com.spring.application.service.DataRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/records")
public class DataRecordController {

    @Autowired
    private DataRecordService dataRecordService;

    @PostMapping
    public ResponseEntity<DataRecord> createRecord(@Valid @RequestBody DataRecord dataRecord) {
        DataRecord createdRecord = dataRecordService.createDataRecord(dataRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }
    @GetMapping("/welcome")
    public String showMessage() {
        return  "Hello,Welcome to Spring Secured Application!";
    }
    @GetMapping("/{id}")
    public ResponseEntity<DataRecord> getRecordById(@PathVariable Long id) {
        DataRecord dataRecord = dataRecordService.getDataRecordById(id);
        if (dataRecord != null) {
            return ResponseEntity.ok(dataRecord);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataRecord> updateRecord(@PathVariable Long id, @Valid @RequestBody DataRecord dataRecord) {
        DataRecord updatedRecord = dataRecordService.updateDataRecord(id, dataRecord);
        if (updatedRecord != null) {
            return ResponseEntity.ok(updatedRecord);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable Long id) {
        dataRecordService.deleteDataRecord(id);
        return ResponseEntity.ok("Record with ID " + id + " has been deleted");
    }
}

