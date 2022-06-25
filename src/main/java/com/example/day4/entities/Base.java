package com.example.day4.entities;

import java.time.LocalDateTime;

public class Base {
    private LocalDateTime createdAt;
    private String createdBy;

    public Base() {

    }

    public Base(LocalDateTime createdAt, String createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }
}