package model;

import java.time.Year;

public class Book implements Comparable<Book> {
    private final String bookId;
    private final String title;
    private final String author;
    private BookStatus status;
    private final Year publicationYear;
    private final double price; // Price in ₹

    public Book(String bookId, String title, String author, Year publicationYear, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.status = BookStatus.AVAILABLE;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return String.format("%s by %s (₹%.2f) [%s]", title, author, price, status);
    }
}