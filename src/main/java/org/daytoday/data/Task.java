package org.daytoday.data;

import java.time.LocalDate;

public class Task {

    private int id;
    private String name;
    private String description;
    private boolean isDone;
    private LocalDate deadline;
    private String taskList;
    private String tag;

    public Task(String name, String description, boolean isDone, LocalDate deadline, String taskList, String tag) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.deadline = deadline;
        this.taskList = taskList;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getTaskList() {
        return taskList;
    }

    public void setTaskList(String taskList) {
        this.taskList = taskList;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
