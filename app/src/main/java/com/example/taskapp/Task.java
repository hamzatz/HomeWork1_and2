package com.example.taskapp;

import java.io.Serializable;

public class Task implements Serializable {
     String title;
     String description;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }



}
