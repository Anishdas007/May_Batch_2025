# 📚 Library Management System

A **Java-based** Library Management System designed to manage books, members, lending operations, and overdue tracking with real-time fine calculations.

---

## 🚀 Features

### 📖 Book Management
- Add and remove books with detailed metadata: **Title**, **Author**, **Price (₹)**, **Publication Year**
- Track book availability: `Available`, `Issued`, `Overdue`

### 👥 Member Management
- Register members with name and contact information
- Track and update fines (₹) for each member

### 🔄 Lending Operations
- Issue books to registered members
- Return books with **automatic overdue fine calculation** (₹10/day)
- Prevent lending to members with unpaid fines or overdue books

### ⏱ Monitoring (Background Thread)
- A separate background thread runs **every minute**:
  - Checks for overdue books
  - Calculates and updates fines
  - Prints overdue notifications with fine details

### 🔍 Search & Reporting
- Find books by **title** or **author**
- Find members by **name** or **email**
- Sort books alphabetically by **title** or **author**

### 💰 Financial Tracking
- All pricing and fine data handled in **Indian Rupees (₹)**
- Integrated system for fine payments
- Notify members about unpaid dues and restrictions

---

## 📂 File Structure

```
src/
├── Main.java                        # Entry point with demo scenarios
├── model/
│   ├── Book.java                    # Book entity (title, author, ₹price, year)
│   ├── BookStatus.java              # Enum (Available, Issued, Overdue)
│   ├── Member.java                  # Member entity with fine tracking
│   └── LendingRecord.java           # Lending record with due dates and fine logic
├── exception/
│   ├── LibraryException.java        # Base exception class
│   ├── BookNotAvailableException.java
│   ├── MemberNotFoundException.java
│   └── OverdueBookException.java
├── repository/
│   └── Repository.java              # Generic in-memory data storage
└── service/
    ├── LibraryService.java          # Core library business logic
    └── OverdueMonitor.java          # Background thread for checking overdue books
```

---

## 🛠 How to Run

> **Pre-requisites**: Java installed on your system (Java 8+)

1. **Navigate to project directory**

2. **Compile the source code**:
   ```bash
   javac -d . src/*.java src/*/*.java
   ```

3. **Run the program**:
   ```bash
   java Main
   ```

You should see sample demo scenarios for adding books, issuing, returning, and fine calculations.

---

## 📌 Notes
- Overdue fine rate is **₹10/day**
- Thread-based monitoring for overdue books is implemented in `OverdueMonitor.java`
- Data is stored in-memory (no database)

---

## 📷 Sample Output (Console)

```
[INFO] Book 'Java Fundamentals' issued to member Rahul
[INFO] Book returned. Fine ₹20 added for 2 days overdue.
[WARNING] Member Rahul has overdue books. Cannot issue new book until fine is paid.
[INFO] Fine of ₹20 paid by Rahul. All dues cleared.
```
