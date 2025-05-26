package com.example.schedule.dto;

import com.example.schedule.domain.Schedule;

public class DeleteResponseDto {
    private Long id;
    private String title;
    private String message;

    public DeleteResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.message = "해당 일정이 삭제되었습니다.";
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
