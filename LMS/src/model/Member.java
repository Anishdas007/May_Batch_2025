package model;

public class Member {
    private final String memberId;
    private final String name;
    private final String email;
    private final String phone;
    private double fineAmount; // Fine amount in ₹

    public Member(String memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.fineAmount = 0.0;
    }

    // Getters and Setters
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void addFine(double amount) {
        fineAmount += amount;
    }

    public void payFine(double amount) {
        fineAmount = Math.max(0, fineAmount - amount);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - ₹%.2f due", name, email, fineAmount);
    }
}