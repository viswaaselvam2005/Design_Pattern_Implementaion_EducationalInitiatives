package Exercise_2.AstronautDailyScheduler.classes;

import Exercise_2.AstronautDailyScheduler.enums.TaskEventType;

public class TaskEvent {
    private final TaskEventType type;
    private final Task task;
    private final String message;

    public TaskEvent(TaskEventType type, Task task, String message) {
        this.type = type;
        this.task = task;
        this.message = message;
    }

    public TaskEventType getType() { return type; }
    public Task getTask() { return task; }
    public String getMessage() { return message; }
}
