package Exercise_2.AstronautDailyScheduler.classes;

import Exercise_2.AstronautDailyScheduler.Exceptions.InvalidTimeFormatException;
import Exercise_2.AstronautDailyScheduler.enums.Priority;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class TaskFactory {
    private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern("HH:mm");

    public static Task createTask(String description, String startTime, String endTime, String priorityStr)
            throws InvalidTimeFormatException, IllegalArgumentException {
        if (description == null || description.trim().isEmpty())
            throw new IllegalArgumentException("Description cannot be empty.");

        LocalTime start = parseTime(startTime);
        LocalTime end = parseTime(endTime);

        if (!start.isBefore(end)) {
            throw new IllegalArgumentException("Start time must be before end time.");
        }

        Priority priority = Priority.fromString(priorityStr);
        return new Task(description.trim(), start, end, priority);
    }

    private static LocalTime parseTime(String t) throws InvalidTimeFormatException {
        try {
            return LocalTime.parse(t.trim(), TIME_FMT);
        } catch (DateTimeParseException | NullPointerException ex) {
            throw new InvalidTimeFormatException("Invalid time format: " + t + ". Expected HH:mm");
        }
    }

    public static LocalTime createTime(String t) throws InvalidTimeFormatException {
        if (t == null || t.isEmpty()) throw new InvalidTimeFormatException("Time cannot be empty");
        try {
            return LocalTime.parse(t.trim(), DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            throw new InvalidTimeFormatException("Invalid time format: " + t + ". Expected HH:mm");
        }
    }

}
