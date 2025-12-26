import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Smart Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task Completed");
            System.out.println("3. Show All Tasks");
            System.out.println("4. Show Completed Tasks");
            System.out.println("5. Show Pending Tasks");
            System.out.println("6. Delete Task");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

           try {
    int op = sc.nextInt();
    sc.nextLine();

    if (op == 1) {
        addTask(sc);
    }
    else if (op == 2) {
        markCompleted(sc);
    }
    else if (op == 3) {
        showTasks(false, false);
    }
    else if (op == 4) {
        showTasks(true, true);
    }
    else if (op == 5) {
        showTasks(true, false);
    }
    else if (op == 6) {
        deleteTask(sc);
    }
    else if (op == 7) {
        System.out.println("Exiting...");
        return;
    }
    else {
        System.out.println("Invalid option!");
    }

} catch (InputMismatchException e) {
    System.out.println("Error: Enter a valid number!");
    sc.nextLine();
}

        }
    }

    private static void addTask(Scanner var0) {
    System.out.print("Enter title: ");
    String title = var0.nextLine();

    System.out.print("Enter description: ");
    String description = var0.nextLine();

    System.out.print("Type 1 for Work, 2 for Personal: ");

    Task task = null;  

    try {
        int type = var0.nextInt();
        var0.nextLine();

        if (type == 1) {
            task = new WorkTask(title, description);
        } else if (type == 2) {
            task = new PersonalTask(title, description);
        } else {
            System.out.println("Invalid type! Task not added.");
            return; 
        }

        tasks.add(task);
        System.out.println("Task added successfully!");

    } catch (InputMismatchException e) {
        System.out.println("Please enter numbers only!");
        var0.nextLine();
    }
}


    private static void markCompleted(Scanner sc) {
        System.out.print("Enter task index: ");
        try {
            int i = sc.nextInt();
            sc.nextLine();
            if (i < 0 || i >= tasks.size()) throw new Exception();
            tasks.get(i).setCompleted(true);
            System.out.println("Marked as completed!");
        } catch (Exception e) {
            System.out.println("Error: Invalid index!");
        }
    }

    private static void showTasks(boolean filter, boolean completed) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            if (filter && tasks.get(i).getIsCompleted() != completed) continue;
            System.out.println("\nIndex: " + i);
            System.out.println(tasks.get(i).getDetails());
        }
    }

    private static void deleteTask(Scanner sc) {
        System.out.print("Enter index to delete: ");
        try {
            int i = sc.nextInt();
            sc.nextLine();
            if (i < 0 || i >= tasks.size()) throw new Exception();
            tasks.remove(i);
            System.out.println("Deleted successfully!");
        } catch (Exception e) {
            System.out.println("Error: Invalid index!");
        }
    }
}
