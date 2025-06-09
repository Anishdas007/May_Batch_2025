import model.*;
import service.LibraryService;
import service.OverdueMonitor;
import java.time.LocalDate;
import java.time.Year;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        LibraryService service = new LibraryService();

        System.out.println("===== ADDING BOOKS =====");
        service.addBook(new Book("B001", "Java Fundamentals", "R. Sharma", Year.of(2020), 450.0));
        service.addBook(new Book("B002", "Advanced Java", "S. Patel", Year.of(2022), 650.0));
        service.addBook(new Book("B003", "Database Systems", "M. Kumar", Year.of(2019), 550.0));
        System.out.println("Books added successfully");

        System.out.println("\n===== REGISTERING MEMBERS =====");
        service.registerMember(new Member("M101", "A. Verma", "a.verma@email.com", "9876543210"));
        service.registerMember(new Member("M102", "P. Singh", "p.singh@email.com", "8765432109"));
        System.out.println("Members registered successfully");

        // Start overdue monitor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        OverdueMonitor monitor = new OverdueMonitor(service);
        executor.execute(monitor);

        // Scenario 1: Successful book issue
        System.out.println("\n===== SCENARIO 1: ISSUING BOOK =====");
        String recordId1 = issueBook(service, "B001", "M101", 1); // Due in 1 day
        System.out.println("Book issued successfully. Record ID: " + recordId1);

        // Scenario 2: Try to issue same book (should fail)
        System.out.println("\n===== SCENARIO 2: TRYING TO ISSUE UNAVAILABLE BOOK =====");
        try {
            issueBook(service, "B001", "M102", 14);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Scenario 3: Wait for book to become overdue
        System.out.println("\n===== SCENARIO 3: WAITING FOR OVERDUE =====");
        System.out.println("Waiting 6 seconds for overdue monitor to run...");
        Thread.sleep(6000);

        // Scenario 4: Try to issue book to member with overdue
        System.out.println("\n===== SCENARIO 4: TRYING TO ISSUE TO MEMBER WITH OVERDUE BOOK =====");
        try {
            issueBook(service, "B002", "M101", 14);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Scenario 5: Return overdue book
        System.out.println("\n===== SCENARIO 5: RETURNING OVERDUE BOOK =====");
        double fine = service.returnBook(recordId1);
        System.out.printf("Book returned. Fine: ₹%.2f%n", fine);

        // Show member status
        System.out.println("\n===== MEMBER STATUS AFTER RETURN =====");
        Member member = service.getMember("M101");
        System.out.println(member);

        // Scenario 6: Pay fine
        System.out.println("\n===== SCENARIO 6: PAYING FINE =====");
        member.payFine(fine);
        System.out.printf("Paid ₹%.2f fine. Remaining due: ₹%.2f%n", fine, member.getFineAmount());

        // Scenario 7: Now issue should succeed
        System.out.println("\n===== SCENARIO 7: ISSUING BOOK AFTER FINE PAYMENT =====");
        String recordId2 = issueBook(service, "B002", "M101", 14);
        System.out.println("Book issued successfully. Record ID: " + recordId2);

        // Shutdown system
        System.out.println("\n===== SHUTTING DOWN SYSTEM =====");
        monitor.stop();
        executor.shutdown();
        service.shutdown();

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
        System.out.println("System shutdown complete");
    }

    private static String issueBook(LibraryService service, String bookId,
            String memberId, int loanDays) throws Exception {
        Book book = service.getBook(bookId);
        Member member = service.getMember(memberId);

        String recordId = "LR-" + System.currentTimeMillis();
        LendingRecord record = new LendingRecord(
                recordId, book, member, LocalDate.now(), loanDays);

        book.setStatus(BookStatus.ISSUED);
        service.getLendingRepo().add(recordId, record);
        return recordId;
    }
}