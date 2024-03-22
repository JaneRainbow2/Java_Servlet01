package com.softserve.itacademy;

import java.util.LinkedList;
import java.util.List;

public class TaskDao {
    private List<Task> tasks = new LinkedList<>();

    private static TaskDao taskDaoInstance = null;

    private TaskDao() {
    }

    public static TaskDao getInstance() {
        if (taskDaoInstance == null) {
            taskDaoInstance = new TaskDao();
            return taskDaoInstance;
        }
        return taskDaoInstance;
    }

    public boolean create(Task task) {
        if (task != null && getTaskByTaskname(task.getTaskName()) == null) {
            return tasks.add(task);
        }
        return false;
    }

    public Task read(final int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

    public boolean update(int id, Task task) {
        int index = tasks.indexOf(read(id));
        return tasks.set(index, task) != null;
    }

    public boolean delete(int id) {
        return tasks.remove(read(id));
    }

    public List<Task> readAll() {
        return tasks;
    }

    public Task getTaskByTaskname(String taskname) {
        return tasks.stream()
                .filter(task -> task.getTaskName().equals(taskname))
                .findFirst()
                .orElse(null);
    }
}
