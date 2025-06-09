package model;

import java.time.LocalDate;

public class EmployeeItem implements Comparable<EmployeeItem> {
    private final int itemId;
    private final String itemDetails;
    private WorkStatus currentStatus;
    private final LocalDate deadline;
    private final UrgencyLevel urgency;

    public enum WorkStatus { NEW, ACTIVE, DONE }
    public enum UrgencyLevel { STANDARD, IMPORTANT, CRITICAL }

    public EmployeeItem(int itemId, String itemDetails, LocalDate deadline, UrgencyLevel urgency) {
        this.itemId = itemId;
        this.itemDetails = itemDetails;
        this.currentStatus = WorkStatus.NEW;
        this.deadline = deadline;
        this.urgency = urgency;
    }

    public int getItemId() { return itemId; }
    public String getItemDetails() { return itemDetails; }
    public WorkStatus getCurrentStatus() { return currentStatus; }
    public void setCurrentStatus(WorkStatus status) { this.currentStatus = status; }
    public LocalDate getDeadline() { return deadline; }
    public UrgencyLevel getUrgency() { return urgency; }

    public boolean isPastDue() {
        return currentStatus != WorkStatus.DONE && deadline.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("Item #%d | Details: %s | Status: %s | Due: %s | Priority: %s",
                itemId, itemDetails, currentStatus, deadline, urgency);
    }

    @Override
    public int compareTo(EmployeeItem other) {
        return this.urgency.compareTo(other.urgency);
    }
}