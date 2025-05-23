package com.example.schedule.service;

import com.example.schedule.domain.Schedule;
import com.example.schedule.dto.CreateRequestDto;
import com.example.schedule.dto.CreateResponseDto;
import com.example.schedule.repositrory.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    // 속성
    private final ScheduleRepository repository;

    // 생성자
    public ScheduleService(ScheduleRepository repository) {
        this.repository = repository;
    }

    // 기능
    public CreateResponseDto save(CreateRequestDto requestDto) {
        // RequsetDto > Entity 변환
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = repository.save(schedule);

        // 저장된 Entity > ResponseDto
        CreateResponseDto responseDto = new CreateResponseDto(schedule);
        return responseDto;
    }

}
