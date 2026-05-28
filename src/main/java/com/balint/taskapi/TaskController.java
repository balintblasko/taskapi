package com.balint.taskapi;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hallo " + name;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
            Optional<Task> task = taskService.getTaskById(id);
                if(task.isPresent()){
                    return ResponseEntity.ok(task.get());
                }
                return ResponseEntity.notFound().build();
        }
    @GetMapping("/gym")
    public String gym(){
        return "Training beginnt um 18 Uhr";
        }
    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        if(task == null){
            return ResponseEntity.badRequest().build();
        }
        Task createdTask = taskService.addTask(task);
        if(createdTask == null){
            return ResponseEntity.badRequest().build();
        } 
        
        return ResponseEntity.ok(createdTask);
    }
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Integer id){
        Optional<Task> deletedTask = taskService.deleteTask(id);
        if(deletedTask.isPresent()){
            return ResponseEntity.ok(deletedTask.get());
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task updatedTask){
        Optional<Task> task = taskService.updateTask(id, updatedTask);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        }
        
        return ResponseEntity.notFound().build();
    } 
}