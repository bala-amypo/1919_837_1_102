package com.example.demo.service;

import com.example.demo.entity.AlertSchedule;
import java.util.List;

public interface AlertScheduleService {
    List<AlertSchedule> getSchedules(Long warrantyId);
}
