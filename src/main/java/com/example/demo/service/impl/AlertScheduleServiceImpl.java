package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository repository;
    private final WarrantyRepository warrantyRepository;

    public AlertScheduleServiceImpl(AlertScheduleRepository repository,
                                    WarrantyRepository warrantyRepository) {
        this.repository = repository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {
        return repository.findByWarrantyId(warrantyId);
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {
        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        schedule.setWarranty(warranty);
        return repository.save(schedule);
    }
}
