package singleton;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    private static volatile Logger instance;

    private volatile LogLevel currentLevel;
    private String filePath;
    private final ReentrantLock lock = new ReentrantLock();
    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1 MB

    private Logger() {
        this.currentLevel = LogLevel.INFO;
        this.filePath = "app.log";
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void setLogLevel(LogLevel level) {
        this.currentLevel = level;
    }

    public void log(String message, LogLevel level) {
        if (level.getPriority() < currentLevel.getPriority()) return;

        lock.lock();
        try {
            rotateIfNeeded();
            String time = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String formatted = time + " [" + level + "] " + message;

            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(formatted + "\n");
            }

            System.out.println(formatted);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void rotateIfNeeded() throws IOException {
        File file = new File(filePath);
        if (file.exists() && file.length() > MAX_FILE_SIZE) {
            Files.move(file.toPath(),
                    new File(filePath + "." + System.currentTimeMillis()).toPath());
        }
    }
}