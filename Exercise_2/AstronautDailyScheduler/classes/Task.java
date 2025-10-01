package Exercise_2.AstronautDailyScheduler.classes;

import Exercise_2.AstronautDailyScheduler.enums.Priority;
import Exercise_2.AstronautDailyScheduler.enums.Status;

import java.time.LocalTime;

public class Task {
    private static int counter = 1;  // auto-increment ID
    private final int id;
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Priority priority;
    private Status status;

    public Task(String description, LocalTime startTime, LocalTime endTime, Priority priority) {
        this.id = counter++;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.status = Status.PENDING;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // ✅ Check conflicts
    public boolean conflictsWith(Task other) {
        return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
    }

    @Override
    public String toString() {
        return String.format(
                "[ID: %d] %s (%s - %s) [%s] Status: %s",
                id,
                description,
                startTime,
                endTime,
                priority,
                status
        );
    }
}
