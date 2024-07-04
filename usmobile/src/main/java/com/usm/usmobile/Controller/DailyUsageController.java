package com.usm.usmobile.controller;

import com.usm.usmobile.model.DailyUsage;
import com.usm.usmobile.service.DailyUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/daily-usage")
public class DailyUsageController {
    @Autowired
    private DailyUsageService dailyUsageService;

    @GetMapping("/current-cycle")
    public List<DailyUsage> getCurrentCycleDailyUsage(@RequestParam String userId, @RequestParam String mdn) {
        return dailyUsageService.getCurrentCycleDailyUsage(userId, mdn);
    }
}