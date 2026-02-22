package singleton;

public enum LogLevel {
    INFO(1),
    WARNING(2),
    ERROR(3);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}