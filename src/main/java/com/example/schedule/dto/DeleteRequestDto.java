package com.example.schedule.dto;

public class DeleteRequestDto {
    // 속성
    private Long id;
    private String name;
    private String password;

    // 기능
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
