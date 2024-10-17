import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Task class to represent a single task
class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return description + "," + isComplete;  // Save as comma-separated values
    }

    public static Task fromString(String taskString) {
        String[] parts = taskString.split(",");
        Task task = new Task(parts[0]);
        if (parts.length > 1 && parts[1].equals("true")) {
            task.markComplete();
        }
        return task;
    }
}

public class TaskManager {

    private static final String FILE_NAME = "tasks.txt";
    private List<Task> tasks;

    public TaskManager() {
        tasks = loadTasksFromFile(FILE_NAME);  // Load tasks from the file on startup
    }

    // Create a new task
    public void createTask(String description) {
        tasks.add(new Task(description));
        saveTasksToFile(FILE_NAME);
        System.out.println("Task created successfully.");
    }

    // Read all tasks
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " (Complete: " + task.isComplete() + ")");
            }
        }
    }

    // Update a task (mark it as complete)
    public void markTaskComplete(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).markComplete();
            saveTasksToFile(FILE_NAME);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Delete a task
    public void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
            saveTasksToFile(FILE_NAME);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Save tasks to a file
    public void saveTasksToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing tasks to file: " + e.getMessage());
        }
    }

    // Load tasks from a file
    public List<Task> loadTasksFromFile(String filename) {
        List<Task> loadedTasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Task.fromString(line);
                loadedTasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks from file: " + e.getMessage());
        }
        return loadedTasks;
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTask Manager:");
            System.out.println("1. List Tasks");
            System.out.println("2. Create Task");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    taskManager.listTasks();
                    break;
                case 2:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.createTask(description);
                    break;
                case 3:
                    taskManager.listTasks();
                    System.out.print("Enter the task number to mark complete: ");
                    int taskIndexComplete = scanner.nextInt() - 1;
                    taskManager.markTaskComplete(taskIndexComplete);
                    break;
                case 4:
                    taskManager.listTasks();
                    System.out.print("Enter the task number to delete: ");
                    int taskIndexDelete = scanner.nextInt() - 1;
                    taskManager.deleteTask(taskIndexDelete);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
