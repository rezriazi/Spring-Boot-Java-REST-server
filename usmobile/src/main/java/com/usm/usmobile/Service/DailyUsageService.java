package com.usm.usmobile.service;

import com.usm.usmobile.model.DailyUsage;
import com.usm.usmobile.repository.DailyUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyUsage {
    @Autowired
    private DailyUsageRepository dailyUsageRepository;

    public List<DailyUsage> getCurrentCycleDailyUsage(String userId, String mdn) {
        return dailyUsageRepository.findByMdnAndUserId(mdn, userId);
    }
}