package com.usm.usmobile.service;

import com.usm.usmobile.model.Cycle;
import com.usm.usmobile.repository.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CycleService {
    @Autowired
    private CycleRepository cycleRepository;

    public List<Cycle> getCycleHistory(String mdn) {
        return cycleRepository.findByMdn(mdn);
    }
}