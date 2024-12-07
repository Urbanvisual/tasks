package com.task.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    @NotBlank(message="Title is required")
    private String title ;
    private String description;
    @Builder.Default
    private Boolean completed = false;
    private LocalDateTime created_at;

}

