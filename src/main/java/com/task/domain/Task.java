package com.task.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@jakarta.persistence.Entity
@Table(name="task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false,updatable=false)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title ;

    @Column(length = 500)
    private String description;

    @Column (nullable = false)
    private Boolean completed = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime created_at;

    public Task (String title, String description) {
        this.title = title;
        this.description = description;
        this.created_at = LocalDateTime.now();
        this.completed = false;
    }
}
