package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@Tag(name = "AlertSchedule")
public class AlertScheduleController {

    private final AlertScheduleService alertScheduleService;

    public AlertScheduleController(AlertScheduleService alertScheduleService) {
        this.alertScheduleService = alertScheduleService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Create an alert schedule for a warranty")
    public AlertSchedule createSchedule(@PathVariable Long warrantyId,
                                        @RequestBody AlertSchedule schedule) {
        return alertScheduleService.createSchedule(warrantyId, schedule);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get all alert schedules for a warranty")
    public List<AlertSchedule> getSchedules(@PathVariable Long warrantyId) {
        return alertScheduleService.getSchedules(warrantyId);
    }
}