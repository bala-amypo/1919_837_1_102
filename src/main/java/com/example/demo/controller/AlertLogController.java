package com.example.demo.controller;
import com.example.demo.entity.AlertLog;
import com.example.demo.service.AlertLogService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/logs")
@Tag(name = "AlertLog")
public class AlertLogController {

    private final AlertLogService alertLogService;

    public AlertLogController(AlertLogService alertLogService) {
        this.alertLogService = alertLogService;
    }

    @PostMapping("/{warrantyId}")
    @Operation(summary = "Add an alert log for a warranty")
    public AlertLog addLog(@PathVariable Long warrantyId,
                           @RequestBody String message) {
        return alertLogService.addLog(warrantyId, message);
    }

    @GetMapping("/{warrantyId}")
    @Operation(summary = "Get all alert logs for a warranty")
    public List<AlertLog> getLogs(@PathVariable Long warrantyId) {
        return alertLogService.getLogs(warrantyId);
    }
}