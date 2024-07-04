package com.usm.usmobile.controller;

import com.usm.usmobile.model.Cycle;
import com.usm.usmobile.service.CycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cycles")
public class CycleController {
    @Autowired
    private CycleService cycleService;

    @GetMapping("/history")
    public List<Cycle> getCycleHistory(@RequestParam String mdn) {
        return cycleService.getCycleHistory(mdn);
    }
}