package com.task.services;

import com.task.domain.Task;
import com.task.dtos.TaskDto;
import com.task.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TasksServices {

    private final TaskRepository taskRepository;

    public TaskDto createTask(TaskDto taskDto) {
            try{
                Task result =  taskRepository.save(new Task(
                        taskDto.getTitle(),
                        taskDto.getDescription()
                ));

                return new TaskDto(
                        result.getId(),
                        result.getTitle(),
                        result.getDescription(),
                        result.getCompleted(),
                        result.getCreated_at()
                );
            }
            catch(Exception e){
                throw new RuntimeException(e);
            }
    }

   // ---------

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();

        return tasks.stream().map(task -> new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCompleted(),
                task.getCreated_at()
        )).toList();
    }

   // -------


    public Optional<TaskDto> taskById(Long id) {
        try{
          Optional<Task> result = taskRepository.findById(id);

            return result.map(task -> new TaskDto(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getCompleted(),
                    task.getCreated_at()
            ));

        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public TaskDto updateTask(Long id) {
        Task existsTask = taskRepository.findById(id)
                .orElseThrow();

        existsTask.setCompleted(!existsTask.getCompleted());

        Task updatedTask = taskRepository.save(existsTask);

        return new TaskDto(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.getDescription(),
                updatedTask.getCompleted(),
                updatedTask.getCreated_at()
        );
    }


    public void deleteTask(Long id) {
        try{
            taskRepository.deleteById(id);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
