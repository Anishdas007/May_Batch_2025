package service;

import model.LendingRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OverdueMonitor implements Runnable {
    private final LibraryService libraryService;
    //A volatile flag used to safely stop the thread across multiple cores/threads.
    //volatile ensures visibility of updates to running across threads.
    private volatile boolean running = true;

    public OverdueMonitor(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                checkOverdueBooks();
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Overdue monitor interrupted");
            }
        }
    }

    private void checkOverdueBooks() {
        List<LendingRecord> overdueRecords = libraryService.getOverdueRecords();
        if (!overdueRecords.isEmpty()) {
            System.out.println("\n=== OVERDUE BOOKS NOTIFICATION ===");
            overdueRecords.forEach(record -> System.out.printf("Member: %s, Book: %s, Due: %s, Days Overdue: %d%n",
                    record.getMember().getName(),
                    record.getBook().getTitle(),
                    record.getDueDate(),
                    LocalDate.now().toEpochDay() - record.getDueDate().toEpochDay()));
            System.out.println("================================");
        }
    }
}