# Employee_Task_Tracker_System

## 📝 Overview
A console-based application to track work items assigned to Employee in an organization, built using core Java principles including OOP, Collections, Generics, Multithreading, and Stream API.

## 🚀 Features
- **Employee Management**: Register and manage Employee with IDs, names, and departments
- **Work Item Tracking**: Create work items with descriptions, deadlines, and urgency levels
- **Task Assignment**: Assign work items to Employee
- **Task Organization**: View tasks sorted by priority or deadline
- **Search Functionality**: Find work items by keyword in descriptions
- **Background Monitoring**: Automatic overdue task detection running every minute
- **Reporting**: View all Employee or all work items at once

## 🛠️ Technologies Used
- Java 11+
- Java Collections Framework
- Multithreading
- Stream API
- Lambda Expressions
- Generics
- Custom Exceptions

## 📂 Project Structure
```
src/
├── model/
│   ├── Employee.java        # Employee entity class
│   └── EmployeeItem.java      # Work item entity class
├── exception/
│   └── ItemNotFoundException.java  # Custom exception
├── repository/
│   └── EmployeeRepository.java         # Generic task repository
├── service/
│   └── EmployeeCoordinator.java        # Core business logic
├── util/
│   └── WorkMonitor.java            # Background task monitor
└── Main.java             # Main application class
```

## ⚙️ How to Run
1. **Prerequisites**:
   - JDK 11 or later installed
   - Maven (optional)

2. **Compilation**:
   ```bash
   javac -d . model/*.java exception/*.java repository/*.java service/*.java util/*.java WorkTrackerApp.java
   ```

3. **Execution**:
   ```bash
   java WorkTrackerApp
   ```

4. **Using Maven** (if configured):
   ```bash
   mvn compile
   mvn exec:java -Dexec.mainClass="Main"
   ```

## 🖥️ Usage Guide
1. **Main Menu Options**:
   ```
   🏢 Work Tracker System 🏢
   1. Register New Employee
   2. Create Work Item
   3. Assign Work Item
   4. View Employee's Tasks
   5. Search Work Items
   6. List All Employee
   7. List All Work Items
   8. Exit System
   ```

2. **Sample Workflow**:
   - Register Employee (option 1)
   - Create work items (option 2)
   - Assign items to Employee (option 3)
   - View tasks organized by priority or deadline (option 4)
   - Search for specific items (option 5)
   - View all registered data (options 6-7)

## 📊 Data Management
- Employee are stored by unique ID
- Work items are stored by unique ID
- The system maintains assignments between Employee and their tasks
- Overdue tasks are automatically detected and displayed

## ⚠️ Known Limitations
- Data is not persisted between sessions (in-memory only)
- No authentication/authorization
- Basic console interface

