package com.balint.taskapi;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private boolean done;

    public Task(Integer id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }
    public Task(){

    }
    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean getDone(){
        return done;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDone(boolean done){
        this.done = done;
    }
}