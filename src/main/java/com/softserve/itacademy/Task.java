package com.softserve.itacademy;

public class Task {
    private int id;
    private String taskName;
    private String priority;
    private static int counter = 1;

    public Task() {
        this.id = counter++;
    }

    public Task(String taskName, String priority) {
        this.id = counter++;
        this.taskName = taskName;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getPriority() {
        return priority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
