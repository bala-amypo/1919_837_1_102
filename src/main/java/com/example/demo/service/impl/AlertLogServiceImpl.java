package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;

import java.util.List;

public class AlertLogServiceImpl {

    private final AlertLogRepository logRepo;
    private final WarrantyRepository warrantyRepo;

    public AlertLogServiceImpl(AlertLogRepository l, WarrantyRepository w) {
        this.logRepo = l;
        this.warrantyRepo = w;
    }

    public AlertLog addLog(Long warrantyId, String msg) {
        Warranty w = warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
        AlertLog log = AlertLog.builder()
                .warranty(w)
                .message(msg)
                .build();
        return logRepo.save(log);
    }

    public List<AlertLog> getLogs(Long warrantyId) {
        warrantyRepo.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));
        return logRepo.findByWarrantyId(warrantyId);
    }
}
