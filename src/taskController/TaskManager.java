package taskController;

import java.io.IOException;
import java.util.*;

public class TaskManager {
    private HashMap<String, TaskStructure> task;

    public TaskManager() {
        this.task = new HashMap<>();
    }

    public void addTask(String name, String description, Date dueDate, boolean completed) {
        TaskStructure newTask = new TaskStructure(name, description, dueDate, completed);
        TaskStructure checkTask = task.get(name);
        if (checkTask != null) {
            System.out.println("Task is already exist");
        } else {
            task.put(name, newTask);
            System.out.println("Task added successfully!");
        }
    }

    public void viewTasks() {
        if (task.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Task List:");
            for (TaskStructure task : task.values()) {
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(String taskName) {
        TaskStructure checkTask = task.get(taskName);
        if (checkTask != null) {
            checkTask.setCompleted(true);
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void deleteTask(String taskName) {
        if (task.containsKey(taskName)) {
            task.remove(taskName);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void filterTasksByStatus(boolean checkStatus) {
        String status = (checkStatus == true) ? "completed" : "pending";

        if (status.equals("pending") || status.equals("completed")) {
            System.out.println("Filtered Tasks:");
            task.forEach((key, val) -> {
                if ((status.equals("pending") && !val.isCompleted()) || (status.equals("completed") && val.isCompleted())) {
                    System.out.println(val);
                }
            });
        } else {
            System.out.println("Invalid status. Please enter true or false.");
        }
    }
}