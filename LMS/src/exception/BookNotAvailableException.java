package exception;

public class BookNotAvailableException extends LibraryException {
    public BookNotAvailableException(String bookId) {
        super("Book " + bookId + " is not available for issue");
    }
}