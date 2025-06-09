// File: src/main/java/com/library/model/LendingRecord.java
package model;

import java.time.LocalDate;

public class LendingRecord {
    private final String recordId;
    private final Book book;
    private final Member member;
    private final LocalDate issueDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    private double fineCalculated; // Fine in ₹

    public LendingRecord(String recordId, Book book, Member member,
            LocalDate issueDate, int loanDays) {
        this.recordId = recordId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = issueDate.plusDays(loanDays);
        this.returnDate = null;
        this.fineCalculated = 0.0;
    }

    // Getters
    public String getRecordId() {
        return recordId;
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFineCalculated() {
        return fineCalculated;
    }

    public boolean isOverdue() {
        return returnDate == null && LocalDate.now().isAfter(dueDate);
    }

    public void returnBook(LocalDate returnDate, double dailyFine) {
        this.returnDate = returnDate;
        if (returnDate.isAfter(dueDate)) {
            //toEpochDay() converts a LocalDate to the number of days since January 1, 1970. Subtracting gives the difference in days.
            long overdueDays = returnDate.toEpochDay() - dueDate.toEpochDay();
            fineCalculated = overdueDays * dailyFine;
            member.addFine(fineCalculated);
        }
    }
}