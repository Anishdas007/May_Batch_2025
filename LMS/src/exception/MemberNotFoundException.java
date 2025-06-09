package exception;

public class MemberNotFoundException extends LibraryException {
    public MemberNotFoundException(String memberId) {
        super("Member " + memberId + " not found");
    }
}