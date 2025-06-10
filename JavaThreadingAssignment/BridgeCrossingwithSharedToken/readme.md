Here's the `README.md` file content for the **Bridge Crossing Problem using `wait()` and `notify()`**:

---

```markdown
# 🛤️ Bridge Crossing Problem - Java (wait/notify Version)

## 🚦 Problem Overview

This project simulates a concurrency problem where multiple people from **City A** and **City B** need to cross a single-lane bridge. Only **one person can cross at a time**, and a **shared token** is required for crossing. The token starts at **City B**, and people can only cross when the token is on their side and the bridge is free.

The implementation uses:
- `synchronized` for mutual exclusion
- `wait()` and `notifyAll()` for thread coordination

---

## 🧠 Concepts Demonstrated

- Thread coordination using **intrinsic locks**
- `wait()` and `notifyAll()` for condition management
- Shared resource management (token and bridge)
- Fairness and signaling between threads

---

## 🛠️ Technologies Used

- Java 8+
- Core multithreading with `Thread`, `synchronized`, `wait`, and `notifyAll`

---

## 📁 File Structure

```

BridgeCrossing/
├── Main.java           # Entry point of the simulation
├── Bridge.java         # Shared bridge resource with synchronization logic
├── Person.java         # Thread class representing a person trying to cross
└── README.md           # Project documentation

````

---

## ✅ How to Run

### Step 1: Compile
```bash
javac Main.java
````

### Step 2: Run

```bash
java Main
```

---

## 📌 Sample Output

```
Alice from CityB is crossing the bridge...
Alice has crossed the bridge. Token is now at City A
Charlie from CityA is crossing the bridge...
Charlie has crossed the bridge. Token is now at City B
Bob from CityB is crossing the bridge...
...
```

---

## 🔄 Logic Summary

* `isTokenAtCityB`: Tracks the token location.
* `hasToken`: Ensures only one person crosses at a time.
* `bridgeInUse`: Prevents multiple users from crossing simultaneously.
* `wait()` causes threads to pause if they can't proceed.
* `notifyAll()` wakes up all threads when bridge becomes free or token moves.

---


