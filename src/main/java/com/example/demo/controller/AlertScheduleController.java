package com.example.demo.controller;

import com.example.demo.entity.AlertSchedule;
import com.example.demo.service.AlertScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@Tag(name = "Alert Schedules")
public class AlertScheduleController {

    private final AlertScheduleService service;

    public AlertScheduleController(AlertScheduleService service) {
        this.service = service;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Create alert schedule")
    public AlertSchedule create(@PathVariable Long warrantyId,
                                @RequestBody AlertSchedule s) {
        return service.createSchedule(warrantyId, s);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "List alert schedules")
    public List<AlertSchedule> list(@PathVariable Long warrantyId) {
        return service.getSchedules(warrantyId);
    }
}
