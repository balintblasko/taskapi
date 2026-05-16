package com.balint.taskapi;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    List<Task> tasks = new ArrayList<>();
    int nextId = 3;

    public TaskService() {
        tasks.add(new Task(1, "Mathe lernen", false));
        tasks.add(new Task(2, "Programmieren lernen", false));
    }

    public List<Task> getTasks(){
        return tasks;
    }
    public Task getTaskById(int id) {
        for(Task t : tasks){
            if(t.getId() == id){
            return t;
            }
        }
        return null;
    }
    public Task addTask(Task task){
         if(task.getTitle() == null || task.getTitle().isBlank()){
            return null;
            }

            task.setId(nextId);
            nextId++;
            tasks.add(task);
            return task;
    }
    public Task deleteTask(int id){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                Task deletedTask = tasks.get(i);
                tasks.remove(i);
                return deletedTask;
            }
        }
        return null;
    }
    public Task updateTask(int id, Task updatedTask){
        if(updatedTask == null || updatedTask.getTitle() == null || updatedTask.getTitle().isBlank()){
                return null;
            }
        for(int i = 0; i < tasks.size(); i++){
            Task t = tasks.get(i);
            if(tasks.get(i).getId() == id){
                t.setTitle(updatedTask.getTitle());
                t.setDone(updatedTask.getDone());
                return t;
            }
            
        }
        return null;
    }
}
