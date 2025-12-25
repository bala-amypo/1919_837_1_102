package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository repository;

    public AlertScheduleServiceImpl(AlertScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        return repository.findByWarrantyId(warrantyId);
    }
}
