package Exercise_2.AstronautDailyScheduler;

import Exercise_2.AstronautDailyScheduler.Exceptions.InvalidTimeFormatException;
import Exercise_2.AstronautDailyScheduler.classes.ConflictNotifier;
import Exercise_2.AstronautDailyScheduler.classes.ScheduleManager;
import Exercise_2.AstronautDailyScheduler.classes.Task;
import Exercise_2.AstronautDailyScheduler.classes.TaskFactory;
import Exercise_2.AstronautDailyScheduler.enums.MenuOption;
import Exercise_2.AstronautDailyScheduler.enums.Priority;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictNotifier());

        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine().trim();
            MenuOption option = MenuOption.fromInput(choice);

            try {
                switch (option) {
                    case ADD:
                        handleAdd(manager);
                        break;

                    case REMOVE:
                        int rid = promptForTaskId("remove");
                        manager.removeTask(rid);
                        break;

                    case VIEW_ALL:
                        List<Task> all = manager.getTasks();
                        if (all.isEmpty()) System.out.println("No tasks scheduled for the day.");
                        else all.forEach(System.out::println);
                        break;

                    case VIEW_BY_PRIORITY:
                        Priority pri = promptForPriority();
                        List<Task> priList = manager.getTasksByPriority(pri);
                        if (priList.isEmpty()) System.out.println("No tasks for priority " + pri);
                        else priList.forEach(System.out::println);
                        break;

                    case VIEW_BY_PRIORITY_TIME:
                        List<Task> sorted = manager.getTasks();
                        sorted.sort((t1, t2) -> {
                            int cmp = t2.getPriority().compareTo(t1.getPriority()); // HIGH first
                            if (cmp == 0) return t1.getStartTime().compareTo(t2.getStartTime());
                            return cmp;
                        });
                        if (sorted.isEmpty()) System.out.println("No tasks available.");
                        else sorted.forEach(System.out::println);
                        break;

                    case MARK_COMPLETE:
                        int taskId = promptForTaskId("mark complete");
                        manager.markTaskComplete(taskId);
                        break;

                    case VIEW_SUMMARY:
                        System.out.println(manager.getSummary());
                        break;

                    case VIEW_REMOVED_TASK:
                        List<Task> removed = manager.getRemovedTasks();
                        if (removed.isEmpty()) System.out.println("No removed tasks yet.");
                        else removed.forEach(System.out::println);
                        break;

                    case UPCOMMING_TASK: {
                        int threshold = promptForThreshold("upcoming tasks");
                        List<Task> nearCurrent = manager.getTasksNearCurrentTime(threshold);
                        if (nearCurrent.isEmpty()) {
                            System.out.println("No tasks starting within the next " + threshold + " minutes.");
                        } else {
                            System.out.println("Tasks starting within the next " + threshold + " minutes:");
                            nearCurrent.forEach(System.out::println);
                        }
                        break;
                    }

                    case VIEW_CRITICAL_TASKS: {
                        int threshold = promptForThreshold("critical tasks");
                        List<Task> criticalTasks = manager.getCriticalTasks(threshold);
                        if (criticalTasks.isEmpty()) {
                            System.out.println("No critical tasks ending within the next " + threshold + " minutes.");
                        } else {
                            System.out.println("Tasks ending within the next " + threshold + " minutes:");
                            criticalTasks.forEach(System.out::println);
                        }
                        break;
                    }

                    case EXIT:
                        System.out.println("Exiting scheduler. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    // --- Helper methods ---
    private static void handleAdd(ScheduleManager manager) throws Exception {
        String desc;
        while (true) {
            System.out.print("Enter description: ");
            desc = scanner.nextLine().trim();
            if (!desc.isEmpty()) break;
            System.out.println("Description cannot be empty. Try again.");
        }

        String start;
        while (true) {
            System.out.print("Enter start time (HH:mm): ");
            start = scanner.nextLine().trim();
            try {
                TaskFactory.createTime(start);
                break;
            } catch (InvalidTimeFormatException e) {
                System.out.println("Invalid start time. " + e.getMessage());
            }
        }

        String end;
        while (true) {
            System.out.print("Enter end time (HH:mm): ");
            end = scanner.nextLine().trim();
            try {
                TaskFactory.createTime(end);
                break;
            } catch (InvalidTimeFormatException e) {
                System.out.println("Invalid end time. " + e.getMessage());
            }
        }

        String priorityStr;
        while (true) {
            System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
            priorityStr = scanner.nextLine().trim().toUpperCase();
            try {
                Priority.fromString(priorityStr);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. " + e.getMessage());
            }
        }

        Task task = TaskFactory.createTask(desc, start, end, priorityStr);
        manager.addTask(task);
    }

    private static int promptForTaskId(String action) {
        int taskId;
        while (true) {
            System.out.print("Enter Task ID to " + action + ": ");
            String input = scanner.nextLine().trim();
            try {
                taskId = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid number.");
            }
        }
        return taskId;
    }

    private static int promptForThreshold(String actionName) {
        int minutes;
        while (true) {
            System.out.print("Enter threshold in minutes for " + actionName + ": ");
            String input = scanner.nextLine().trim();
            try {
                minutes = Integer.parseInt(input);
                if (minutes > 0) break;
                System.out.println("Threshold must be positive.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
        return minutes;
    }

    private static Priority promptForPriority() {
        Priority pri;
        while (true) {
            System.out.print("Enter priority (HIGH/MEDIUM/LOW): ");
            String p = scanner.nextLine().trim().toUpperCase();
            try {
                pri = Priority.fromString(p);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid priority. " + e.getMessage());
            }
        }
        return pri;
    }

    private static void printMenu() {
        System.out.println("\n=== Astronaut Daily Scheduler ===");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task (by ID)");
        System.out.println("3. View All Tasks (time order)");
        System.out.println("4. View Tasks by Priority");
        System.out.println("5. View Tasks by Priority + Time");
        System.out.println("6. Mark Task Complete (by ID)");
        System.out.println("7. View Summary");
        System.out.println("8. View Removed Tasks");
        System.out.println("9. View Upcoming Tasks");
        System.out.println("10. View Critical Tasks");
        System.out.println("11. Exit");
    }
}
