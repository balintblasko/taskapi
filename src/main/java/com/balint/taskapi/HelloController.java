package com.balint.taskapi;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    List<Task> tasks = new ArrayList<>();

    public HelloController() {
        tasks.add(new Task(1, "Mathe lernen", false));
        tasks.add(new Task(2, "Programmieren lernen", false));
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hallo " + name;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/tasks/{id}")
        public Task getTaskById(@PathVariable int id) {
            for(Task t : tasks){
                if(t.id == id){
                    return t;
                }
            } return null;
        }
    @GetMapping("/gym")
    public String gym(){
        return "Training beginnt um 18 Uhr";
        }
    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }
}