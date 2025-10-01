package Exercise_2.AstronautDailyScheduler.enums;

public enum Priority {
    HIGH(3), MEDIUM(2), LOW(1);

    private final int level;
    Priority(int level) { this.level = level; }
    public int getLevel() { return level; }

    public static Priority fromString(String str) {
        switch (str.toUpperCase()) {
            case "HIGH": return HIGH;
            case "MEDIUM": return MEDIUM;
            case "LOW": return LOW;
            default: throw new IllegalArgumentException("Invalid priority: " + str);
        }
    }
}

