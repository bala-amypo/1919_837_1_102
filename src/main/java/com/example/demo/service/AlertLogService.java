package com.example.demo.service;

import com.example.demo.entity.AlertLog;

import java.util.List;

public interface AlertLogService {

    List<AlertLog> getLogs(Long warrantyId);

    AlertLog addLog(Long warrantyId, String message);
}
