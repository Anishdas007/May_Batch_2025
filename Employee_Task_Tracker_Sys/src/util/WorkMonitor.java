package util;

import model.EmployeeItem;
import service.EmployeeCoordinator;
import java.util.List;

public class WorkMonitor implements Runnable {
    private final EmployeeCoordinator coordinator;
    private volatile boolean shouldRun = true;

    public WorkMonitor(EmployeeCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    @Override
    public void run() {
        while (shouldRun) {
            try {
                List<EmployeeItem> overdueItems = coordinator.getOverdueItems();
                if (!overdueItems.isEmpty()) {
                    System.out.println("\n⚠️ Overdue Work Items ⚠️");
                    overdueItems.forEach(System.out::println);
                    System.out.println("----------------------------");
                }
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println("Work monitoring interrupted");
                shouldRun = false;
            }
        }
    }

    public void stopMonitoring() {
        shouldRun = false;
    }
}