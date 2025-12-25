package com.example.demo.service.impl;

import com.example.demo.entity.AlertLog;
import com.example.demo.repository.AlertLogRepository;
import com.example.demo.service.AlertLogService;
import org.springframework.stereotype.Service;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    private final AlertLogRepository repository;

    public AlertLogServiceImpl(AlertLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlertLog save(AlertLog log) {
        return repository.save(log);
    }
}
