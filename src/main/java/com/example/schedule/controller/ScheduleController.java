package com.example.schedule.controller;

import com.example.schedule.dto.CreateRequestDto;
import com.example.schedule.dto.CreateResponseDto;
import com.example.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

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
    public CreateResponseDto save(@RequestBody CreateRequestDto requestDto) {
        CreateResponseDto createResponseDto = scheduleService.save(requestDto);
        return createResponseDto;
    }


}
