package com.example.demo.service.impl;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.entity.Warranty;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.AlertScheduleRepository;
import com.example.demo.repository.WarrantyRepository;
import com.example.demo.service.AlertScheduleService;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlertScheduleServiceImpl implements AlertScheduleService {

    private final AlertScheduleRepository scheduleRepository;
    private final WarrantyRepository warrantyRepository;

    public AlertScheduleServiceImpl(AlertScheduleRepository scheduleRepository,
                                    WarrantyRepository warrantyRepository) {
        this.scheduleRepository = scheduleRepository;
        this.warrantyRepository = warrantyRepository;
    }

    @Override
    public AlertSchedule createSchedule(Long warrantyId, AlertSchedule schedule) {

        Warranty warranty = warrantyRepository.findById(warrantyId)
                .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));

        if (schedule.getDaysBeforeExpiry() < 0) {
            throw new IllegalArgumentException("daysBeforeExpiry must be >= 0");
        }

        schedule.setWarranty(warranty);
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<AlertSchedule> getSchedules(Long warrantyId) {

        if (!warrantyRepository.findById(warrantyId).isPresent()) {
            throw new ResourceNotFoundException("Warranty not found");
        }

        return scheduleRepository.findByWarrantyId(warrantyId);
    }
}
