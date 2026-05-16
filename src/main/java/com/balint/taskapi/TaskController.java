package com.balint.taskapi;
import java.util.List;
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
        public ResponseEntity<Task> getTaskById(@PathVariable int id) {
            Task task = taskService.getTaskById(id);
                if(task != null){
                    return ResponseEntity.ok(task);
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
    public ResponseEntity<Task> deleteTask(@PathVariable int id){
        Task deletedTask = taskService.deleteTask(id);
        if(deletedTask != null){
            return ResponseEntity.ok(deletedTask);
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask){
        Task task = taskService.updateTask(id, updatedTask);
        if(task != null){
            return ResponseEntity.ok(task);
        }
        
        return ResponseEntity.notFound().build();
    } 
}