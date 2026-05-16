package com.balint.taskapi;

public class Task {

    private int id;
    private String title;
    private boolean done;

    public Task(int id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }
    public Task(){
        
    }
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public boolean getDone(){
        return done;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDone(boolean done){
        this.done = done;
    }
}