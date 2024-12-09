package com.task.controller;

import com.task.domain.Task;
import com.task.dtos.TaskDto;
import com.task.services.TasksServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final TasksServices tasksServices;

    @GetMapping("/")
    public String ping(){
        return "pong";
    }

    @PostMapping ("/task")
    public TaskDto createTask(@RequestBody TaskDto task) {
      return tasksServices.createTask(task);
    }



    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = tasksServices.getAllTasks();
        return ResponseEntity.ok(tasks.reversed());
    }


    @GetMapping ("/task/{id}")
    public TaskDto taskById(@PathVariable Long id) {
        Optional<TaskDto> result = tasksServices.taskById(id);

        return result.orElse(null);
    }

    @PutMapping ("/task/{id}")
    public TaskDto updateTask(@PathVariable Long id) {
        return tasksServices.updateTask(id);
    }


    @DeleteMapping ("/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksServices.deleteTask(id);
    }

}
