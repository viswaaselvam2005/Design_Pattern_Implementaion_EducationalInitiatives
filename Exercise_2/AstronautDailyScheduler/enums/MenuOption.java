package Exercise_2.AstronautDailyScheduler.enums;

public enum MenuOption {
    ADD,
    REMOVE,
    VIEW_ALL,
    VIEW_BY_PRIORITY,
    VIEW_BY_PRIORITY_TIME,
    MARK_COMPLETE,
    VIEW_SUMMARY,
    VIEW_REMOVED_TASK,
    UPCOMMING_TASK,
    VIEW_CRITICAL_TASKS,
    EXIT,
    INVALID;

    public static MenuOption fromInput(String input) {
        switch (input) {
            case "1": return ADD;
            case "2": return REMOVE;
            case "3": return VIEW_ALL;
            case "4": return VIEW_BY_PRIORITY;
            case "5": return VIEW_BY_PRIORITY_TIME;
            case "6": return MARK_COMPLETE;
            case "7": return VIEW_SUMMARY;
            case "8": return VIEW_REMOVED_TASK;
            case "9": return UPCOMMING_TASK;
            case "10": return VIEW_CRITICAL_TASKS;
            case "11": return EXIT;
            default: return INVALID;
        }
    }
}
