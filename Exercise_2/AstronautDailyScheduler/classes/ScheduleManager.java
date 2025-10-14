package Exercise_2.AstronautDailyScheduler.classes;

import Exercise_2.AstronautDailyScheduler.Exceptions.TaskConflictException;
import Exercise_2.AstronautDailyScheduler.Exceptions.TaskNotFoundException;
import Exercise_2.AstronautDailyScheduler.enums.Priority;
import Exercise_2.AstronautDailyScheduler.enums.Status;
import Exercise_2.AstronautDailyScheduler.enums.TaskEventType;
import Exercise_2.AstronautDailyScheduler.interfaces.ScheduleObserver;

import java.time.LocalTime;

import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Task> removedTasks;
    private final List<ScheduleObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        removedTasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(ScheduleObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(TaskEvent event) {
        for (ScheduleObserver obs : observers) {
            obs.onTaskEvent(event);
        }
    }

    public synchronized void addTask(Task task) throws TaskConflictException {
        for (Task t : tasks) {
            if (task.conflictsWith(t)) {
                TaskEvent event = new TaskEvent(
                        TaskEventType.CONFLICT,
                        task,
                        "Task \"" + task.getDescription() +
                                "\" conflicts with existing task \"" + t.getDescription() + "\""
                );
                notifyObservers(event);
                throw new TaskConflictException(event.getMessage());
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));

        notifyObservers(new TaskEvent(
                TaskEventType.ADDED,
                task,
                "Task \"" + task.getDescription() + "\" added successfully."
        ));
    }

    public synchronized void removeTask(int taskId) throws TaskNotFoundException {
        Optional<Task> toRemove = tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst();

        if (toRemove.isPresent()) {
            Task removed = toRemove.get();
            tasks.remove(removed);
            removedTasks.add(removed);  

            notifyObservers(new TaskEvent(
                    TaskEventType.REMOVED,
                    removed,
                    "Task with ID " + taskId + " removed successfully."
            ));
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
    }

    public synchronized List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public synchronized List<Task> getTasksByPriority(Priority priority) {
        return tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
    }

    public synchronized void markTaskComplete(int taskId) throws TaskNotFoundException {
        Optional<Task> toMark = tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst();

        if (toMark.isPresent()) {
            toMark.get().setStatus(Status.COMPLETED);
            notifyObservers(new TaskEvent(
                    TaskEventType.COMPLETED,
                    toMark.get(),
                    "Task with ID " + taskId + " marked as completed."
            ));
        } else {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
    }

    public synchronized String getSummary() {
        int total = tasks.size();
        long completed = tasks.stream().filter(t -> t.getStatus() == Status.COMPLETED).count();
        long pending = total - completed;

        long high = tasks.stream().filter(t -> t.getPriority() == Priority.HIGH).count();
        long medium = tasks.stream().filter(t -> t.getPriority() == Priority.MEDIUM).count();
        long low = tasks.stream().filter(t -> t.getPriority() == Priority.LOW).count();

        StringBuilder sb = new StringBuilder();
        sb.append("Summary:\n");
        sb.append("Total Tasks: ").append(total).append("\n");
        sb.append("Completed: ").append(completed).append("\n");
        sb.append("Pending: ").append(pending).append("\n");
        sb.append("High: ").append(high)
                .append(" | Medium: ").append(medium)
                .append(" | Low: ").append(low)
                .append("\n");
        sb.append("Removed so far: ").append(removedTasks.size());

        return sb.toString();
    }


    public synchronized List<Task> getRemovedTasks() {
        return new ArrayList<>(removedTasks);
    }
    
    public synchronized List<Task> getTasksNearCurrentTime(int minutesThreshold) {
        LocalTime now = LocalTime.now();
        return tasks.stream()
                .filter(t -> t.getStatus() != Status.COMPLETED)
                .filter(t -> {
                    long minutesUntilStart = java.time.Duration.between(now, t.getStartTime()).toMinutes();
                    return minutesUntilStart >= 0 && minutesUntilStart <= minutesThreshold;
                })
                .sorted(Comparator.comparing(Task::getStartTime))
                .collect(Collectors.toList());
    }

    public synchronized List<Task> getCriticalTasks(int minutesThreshold) {
        LocalTime now = LocalTime.now();
        return tasks.stream()
                .filter(t -> t.getStatus() != Status.COMPLETED) // only incomplete tasks
                .filter(t -> {
                    long minutesUntilEnd = java.time.Duration.between(now, t.getEndTime()).toMinutes();
                    return minutesUntilEnd >= 0 && minutesUntilEnd <= minutesThreshold;
                })
                .sorted(Comparator.comparing(Task::getEndTime))
                .collect(Collectors.toList());
    }

}
