package com.example.schedule.service;

import com.example.schedule.domain.Schedule;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.repositrory.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    // 속성
    private final ScheduleRepository repository;

    // 생성자
    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    // 기능
    // Create
    public ScheduleResponseDto save(ScheduleRequestDto requestDto) {
        // RequsetDto > Entity 변환
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = repository.save(schedule);

        // 저장된 Entity > ResponseDto
        ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
        return responseDto;
    }

    // FindAll
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> scheduleList = repository.findAll();
        List<ScheduleResponseDto> responseDtoList = new ArrayList<>();

        for(Schedule schedule : scheduleList) {
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule);
            responseDtoList.add(dto);
        }
        return responseDtoList;
    }

}
