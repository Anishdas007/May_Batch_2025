```markdown
# 🏢 Employee Team Organizer

This Java program simulates the organization of employees across departments, identifies specific employees by name, and then groups them into randomized sports teams and divisions.

---

## 📌 Features

- Combines employees from multiple departments into one list.
- Filters and sorts employees by names starting with a specific letter.
- Groups employees alphabetically by the first letter of their names.
- Creates 5 randomized sports teams.
- Merges the teams into 3 divisions.

---

## 🧑‍💼 Employee Dataset

The program includes **15 employee names**, distributed across 3 departments:

```

Department 1: Amit, Anjali, Bharat, Chirag, Deepika
Department 2: Esha, Farhan, Gaurav, Harsh, Isha
Department 3: Jatin, Kavita, Lakshmi, Manish, Neha

````

---

## 🔧 How It Works

1. **Combine Departments**: All employees from different departments are merged into a single list.
2. **Filter Names**: Identifies employees whose names begin with a specified letter (e.g., 'A').
3. **Group by Letter**: Names are grouped by their starting letter and sorted alphabetically.
4. **Create Teams**: Randomly assigns employees into 5 sports teams.
5. **Form Divisions**: Merges the 5 teams into 3 balanced divisions.

---

## 🛠 Technologies Used

- Java 17+
- Java Stream API
- Collections Framework

---

## 🚀 How to Run

1. Clone this repository or copy the `.java` file.
2. Compile the program:

```bash
javac IndianTeamOrganizer.java
````

3. Run the program:

```bash
java TeamOrganization
```

---

## 🖼 Sample Output

```
🔹 All Employees:
- Amit
- Anjali
- Bharat
...

🔹 Employees starting with 'A':
Amit
Anjali

🔹 Grouped by First Letter:
A: [Amit, Anjali]
B: [Bharat]
...

🔹 Sports Teams:
Team 1:
 - Manish
 - Bharat
 - Chirag
...

🔹 Divisions:
Division 1:
 - Manish
 - Bharat
 - Chirag
...
```



