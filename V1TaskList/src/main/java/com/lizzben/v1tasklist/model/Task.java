package com.lizzben.v1tasklist.model;


/**
 * V1 Task
 */
public class Task {
    public String id;
    public String content;

    public Task(String id, String content) {
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
