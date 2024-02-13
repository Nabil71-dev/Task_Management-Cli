import taskController.TaskManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\nTask Manager:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Filter Tasks by Status");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Due Date (yyyy-MM-dd): ");
                    Date dueDate = null;
                    try {
                        dueDate = dateFormat.parse(scanner.nextLine());
                    } catch (java.text.ParseException e) {
                        System.out.println("Invalid date format. Task not added.");
                        return;
                    }
                    manager.addTask(name, description, dueDate, false);
                    break;
                case 2:
                    manager.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter name of task to mark completed: ");
                    try {
                        String nameToComplete = scanner.next();
                        manager.markTaskAsCompleted(nameToComplete);
                    } catch (Exception e) {
                        System.out.println("Please enter valid string");
                    }
                    break;
                case 4:
                    System.out.print("Enter name of task to delete: ");
                    try {
                        String nameToDelete = scanner.next();
                        manager.deleteTask(nameToDelete);
                    } catch (Exception e) {
                        System.out.println("Please enter valid string");
                    }
                    break;
                case 5:
                    System.out.print("Filter by completed (true/false): ");
                    try {
                        boolean completed = scanner.nextBoolean();
                        manager.filterTasksByStatus(completed);
                    } catch (Exception e) {
                        System.out.println("Please enter valid type of input example : true or false");
                    }

                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
}