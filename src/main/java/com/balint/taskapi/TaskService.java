package com.balint.taskapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    public Optional<Task> getTaskById(Integer id) {
            return taskRepository.findById(id);
    }
    public Task addTask(Task task){
         if(task.getTitle() == null || task.getTitle().isBlank()){
            return null;
            }
            return taskRepository.save(task);
    }
    public Optional<Task> deleteTask(Integer id){
        Optional<Task> deletedTask = taskRepository.findById(id);
        if(deletedTask.isPresent()){
                taskRepository.deleteById(id);
            }
            return deletedTask;
    }
    public Optional<Task> updateTask(Integer id, Task updatedTask){
        if(updatedTask == null || updatedTask.getTitle() == null || updatedTask.getTitle().isBlank()){
            return Optional.empty();
        }

        Optional<Task> existingTask = taskRepository.findById(id);

        if(existingTask.isPresent()){
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDone(updatedTask.getDone());

            Task savedTask = taskRepository.save(task);
            return Optional.of(savedTask);
        }

        return Optional.empty();
    }
}
