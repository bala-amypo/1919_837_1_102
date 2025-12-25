package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository repository;
    private final WarrantyRepository warrantyRepository;

    public AlertLogServiceImpl(AlertLogRepository repository,
                               WarrantyRepository warrantyRepository) {
        this.repository = repository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public List<AlertLog> getLogs(Long warrantyId) {
        return repository.findByWarrantyId(warrantyId);
    }

    @Override
    public AlertLog addLog(Long warrantyId, String message) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        AlertLog log = AlertLog.builder()
                .warranty(warranty)
                .message(message)
                .sentAt(LocalDateTime.now())
                .build();

        return repository.save(log);
    }
}
