package com.example.schedule.service;

import com.example.schedule.domain.Schedule;
import com.example.schedule.dto.DeleteRequestDto;
import com.example.schedule.dto.DeleteResponseDto;
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

    // FindOne
    public ScheduleResponseDto findOne(Long id) {
        Schedule foundschedule = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다. id : " + id));
        ScheduleResponseDto responseDto = new ScheduleResponseDto(foundschedule);
        return responseDto;
    }

    // Update
    public ScheduleResponseDto update(ScheduleRequestDto requestDto, Long id) {
        Schedule foundschedule = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다. id : " + id));

        if (!foundschedule.getName().equals(requestDto.getName()) || !foundschedule.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("이름 , 비밀번호가 일치하지 않아 수정할 수 없습니다.");
        }
        foundschedule.changeTitle(requestDto.getTitle());
        foundschedule.changeContent(requestDto.getContent());

        Schedule updatedSchedule = repository.save(foundschedule);
        ScheduleResponseDto responseDto = new ScheduleResponseDto(updatedSchedule);

        return responseDto;
    }

    // Delete
    public DeleteResponseDto delete(DeleteRequestDto requestDto, Long id) {
        Schedule foundschedule = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다. id : " + id));

        if (!foundschedule.getName().equals(requestDto.getName()) || !foundschedule.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("이름 , 비밀번호가 일치하지 않아 삭제할 수 없습니다.");
        }

        DeleteResponseDto responseDto = new DeleteResponseDto(foundschedule);
        repository.delete(foundschedule);

        return responseDto;
    }
}
