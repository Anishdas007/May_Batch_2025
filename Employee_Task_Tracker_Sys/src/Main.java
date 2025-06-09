import model.Employee;
import model.EmployeeItem;
import model.EmployeeItem.UrgencyLevel;
import service.EmployeeCoordinator;
import util.WorkMonitor;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class Main {
    private static EmployeeCoordinator coordinator = new EmployeeCoordinator();
    private static Map<Integer, Employee> employee = new HashMap<>();
    private static Map<Integer, EmployeeItem> employeeItems = new HashMap<>();
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        WorkMonitor monitor = new WorkMonitor(coordinator);
        Executors.newSingleThreadExecutor().submit(monitor);
        boolean appRunning = true;

        while (appRunning) {
            System.out.println("\n Work Tracker System ");
            System.out.println("1. Register New Worker");
            System.out.println("2. Create Work Item");
            System.out.println("3. Assign Work Item");
            System.out.println("4. View Worker's Tasks");
            System.out.println("5. Search Work Items");
            System.out.println("6. List All Workers");
            System.out.println("7. List All Work Items");
            System.out.println("8. Exit System");
            System.out.print("Select option: ");

            try {
                int selection = inputScanner.nextInt();
                inputScanner.nextLine();

                switch (selection) {
                    case 1:
                        registerWorker();
                        break;
                    case 2:
                        createWorkItem();
                        break;
                    case 3:
                        assignWorkItem();
                        break;
                    case 4:
                        viewWorkerTasks();
                        break;
                    case 5:
                        searchWorkItems();
                        break;
                    case 6:
                        listAllWorkers();
                        break;
                    case 7:
                        listAllWorkItems();
                        break;
                    case 8:
                        appRunning = false;
                        monitor.stopMonitoring();
                        break;
                    default:
                        System.out.println("Invalid selection!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                inputScanner.nextLine();
            }
        }

        inputScanner.close();
        System.out.println("System shutdown completed.");
    }

    private static void registerWorker() {
        System.out.print("Enter worker ID: ");
        int id = inputScanner.nextInt();
        inputScanner.nextLine();

        if (employee.containsKey(id)) {
            System.out.println("Worker ID already exists!");
            return;
        }

        System.out.print("Enter full name: ");
        String name = inputScanner.nextLine();
        System.out.print("Enter team/department: ");
        String team = inputScanner.nextLine();

        Employee newEmployee = new Employee(id, name, team);
        employee.put(id, newEmployee);
        System.out.println("Employee registered: " + newEmployee);
    }

    private static void createWorkItem() {
        System.out.print("Enter item ID: ");
        int id = inputScanner.nextInt();
        inputScanner.nextLine();

        if (employeeItems.containsKey(id)) {
            System.out.println("Work item ID already exists!");
            return;
        }

        System.out.print("Enter item details: ");
        String details = inputScanner.nextLine();

        LocalDate deadline;
        try {
            System.out.print("Enter deadline (YYYY-MM-DD): ");
            deadline = LocalDate.parse(inputScanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid date format! Use YYYY-MM-DD");
            return;
        }

        UrgencyLevel urgency;
        try {
            System.out.print("Enter urgency (STANDARD/IMPORTANT/CRITICAL): ");
            urgency = UrgencyLevel.valueOf(inputScanner.nextLine().toUpperCase());
        } catch (Exception e) {
            System.out.println("Invalid urgency level!");
            return;
        }

        EmployeeItem newItem = new EmployeeItem(id, details, deadline, urgency);
        employeeItems.put(id, newItem);
        System.out.println("Work item created: " + newItem);
    }

    private static void assignWorkItem() {
        System.out.print("Enter worker ID: ");
        int employeeId = inputScanner.nextInt();
        System.out.print("Enter item ID: ");
        int itemId = inputScanner.nextInt();
        inputScanner.nextLine();

        Employee emp = employee.get(employeeId);
        EmployeeItem item = employeeItems.get(itemId);

        if (emp == null) {
            System.out.println("Worker not found!");
            return;
        }

        if (item == null) {
            System.out.println("Work item not found!");
            return;
        }

        coordinator.assignWorkToWorker(emp, item);
        System.out.println("Successfully assigned " + item + " to " + emp);
    }

    private static void viewWorkerTasks() {
        System.out.print("Enter worker ID: ");
        int empId = inputScanner.nextInt();
        inputScanner.nextLine();

        Employee emp = employee.get(empId);
        if (emp == null) {
            System.out.println("Worker not found!");
            return;
        }

        System.out.println("\nTasks for " + emp.getName() + ":");
        System.out.println("1. By Priority");
        System.out.println("2. By Deadline");
        System.out.print("Select view option: ");

        int viewChoice = inputScanner.nextInt();
        inputScanner.nextLine();

        List<EmployeeItem> tasks;
        if (viewChoice == 1) {
            tasks = coordinator.organizeByPriority(emp);
            System.out.println("\nTasks organized by priority:");
        } else if (viewChoice == 2) {
            tasks = coordinator.organizeByDeadline(emp);
            System.out.println("\nTasks organized by deadline:");
        } else {
            System.out.println("Invalid option!");
            return;
        }

        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned to this worker.");
        } else {
            tasks.forEach(System.out::println);
        }
    }

    private static void searchWorkItems() {
        System.out.print("Enter search term: ");
        String term = inputScanner.nextLine();

        List<EmployeeItem> results = coordinator.searchInDescriptions(term);
        if (results.isEmpty()) {
            System.out.println("No matching work items found.");
        } else {
            System.out.println("\nMatching work items:");
            results.forEach(System.out::println);
        }
    }

    private static void listAllWorkers() {
        if (employee.isEmpty()) {
            System.out.println("No workers registered yet.");
            return;
        }

        System.out.println("\nAll Registered Workers:");
        employee.values().forEach(System.out::println);
    }

    private static void listAllWorkItems() {
        if (employeeItems.isEmpty()) {
            System.out.println("No work items created yet.");
            return;
        }

        System.out.println("\nAll Work Items:");
        employeeItems.values().forEach(System.out::println);
    }
}