package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    // 속성
    private final ScheduleService scheduleService;

    // 생성자
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 기능
    @PostMapping("/create")
    public ScheduleResponseDto save(@RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto scheduleResponseDto = scheduleService.save(requestDto);
        return scheduleResponseDto;
    }

    @GetMapping("/find-all")
    public List<ScheduleResponseDto> findAll() {
        List<ScheduleResponseDto> schedules = scheduleService.findAll();
        return schedules;
    }
}
