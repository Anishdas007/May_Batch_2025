package exception;

public class OverdueBookException extends LibraryException {
    public OverdueBookException(String memberId, int overdueCount) {
        super("Member " + memberId + " has " + overdueCount + " overdue books");
    }
}