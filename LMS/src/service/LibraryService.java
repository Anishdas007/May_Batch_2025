package service;

import exception.*;
import model.*;
import repository.Repository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class LibraryService {
    private final Repository<Book> bookRepo = new Repository<>("Book");
    private final Repository<Member> memberRepo = new Repository<>("Member");
    private final Repository<LendingRecord> lendingRepo = new Repository<>("LendingRecord");
    private final double dailyFineRate = 10.0;

    // Book management
    public void addBook(Book book) {
        bookRepo.add(book.getBookId(), book);
    }

    public Book getBook(String bookId) throws LibraryException {
        return bookRepo.get(bookId);
    }

    // Member management
    public void registerMember(Member member) {
        memberRepo.add(member.getMemberId(), member);
    }

    public Member getMember(String memberId) throws LibraryException {
        return memberRepo.get(memberId);
    }

    // Lending operations
    public void issueBook(String bookId, String memberId, int loanDays)
            throws LibraryException {

        Book book = bookRepo.get(bookId);
        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new BookNotAvailableException(bookId);
        }

        Member member = memberRepo.get(memberId);
        checkOverdueBooks(memberId);

        String recordId = "LR-" + System.currentTimeMillis();
        LendingRecord record = new LendingRecord(
                recordId, book, member, LocalDate.now(), loanDays);

        book.setStatus(BookStatus.ISSUED);
        lendingRepo.add(recordId, record);
    }

    private void checkOverdueBooks(String memberId) throws OverdueBookException {
        long overdueCount = lendingRepo.search(record -> record.getMember().getMemberId().equals(memberId) &&
                record.isOverdue()).size();

        if (overdueCount > 0) {
            throw new OverdueBookException(memberId, (int) overdueCount);
        }
    }

    public double returnBook(String recordId) throws LibraryException {
        LendingRecord record = lendingRepo.get(recordId);
        record.returnBook(LocalDate.now(), dailyFineRate);
        return record.getFineCalculated();
    }

    // Get overdue records for monitor
    public List<LendingRecord> getOverdueRecords() {
        return lendingRepo.search(record -> record.getReturnDate() == null &&
                LocalDate.now().isAfter(record.getDueDate()));
    }

    // Search operations
    public List<Book> findBooksByAuthor(String author) {
        return bookRepo.search(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    public List<Member> findMembersByName(String name) {
        return memberRepo.search(member -> member.getName().equalsIgnoreCase(name));
    }

    // Sorting
    public List<Book> getBooksSortedByTitle() {
        List<Book> books = bookRepo.getAll();
        books.sort(Comparator.naturalOrder());
        return books;
    }

    public List<Book> getBooksSortedByAuthor() {
        List<Book> books = bookRepo.getAll();
        books.sort(Comparator.comparing(Book::getAuthor));
        return books;
    }

    public Repository<LendingRecord> getLendingRepo() {
        return lendingRepo;
    }
    public void shutdown() {
        System.out.println("Library service shutdown complete");
    }
}