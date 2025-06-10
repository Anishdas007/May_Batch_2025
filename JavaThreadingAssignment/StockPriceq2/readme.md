Here is a `README.md` file for your **Stock Price Batch Processor with Multithreading** Java project:

---

```markdown
# 📈 Stock Price Batch Processor with Multithreading

This Java application demonstrates efficient file reading and batch processing of stock price data using multithreading with `CompletableFuture` and `ExecutorService`.

## 🚀 Overview

The program reads a CSV file containing stock names and their respective prices, processes the data in parallel batches using multiple threads, and prints the processed output.

### Key Features:
- Reads stock data from a CSV file
- Splits the data into 10 batches
- Processes each batch concurrently using `CompletableFuture` and a fixed thread pool
- Collects and displays the final merged results

## 📂 Project Structure

```

StockPriceq2/
├── src/
│   ├── StockPrice\_Q2.java
│   ├── stocks.csv

```

## 🧠 Concepts Used

- **Java File I/O** with `BufferedReader`
- **Custom Generic Pair class** to store stock-price pairs
- **Multithreading** using `ExecutorService` and `CompletableFuture`
- **Batch processing** by dividing input into chunks
- **Streams and Lambda expressions** for efficient result aggregation

## 📊 Input Format

The `stocks.csv` file should contain stock data in the following format:

```

TCS,3300.25
INFY,1450.50
RELIANCE,2701.75
...

````

Each line contains:
- Stock symbol (e.g., `TCS`)
- Stock price (e.g., `3300.25`)

## ⚙️ How It Works

1. **ReadFile()**:
   - Reads lines from a CSV file.
   - Parses each line into a `Pair<String, Float>` (stock name and price).
   - Stores the parsed data into a list.

2. **process()**:
   - Splits the data into 10 equal (or nearly equal) batches.
   - Each batch is processed by a separate thread using `CompletableFuture`.
   - Each thread logs the data it processes.
   - Finally, all results are combined into a single list and returned.

3. **main()**:
   - Calls the above methods to process data.
   - Displays the final processed stock-price list.

## 🖥️ How to Run

### Requirements:
- Java 8 or higher
- `stocks.csv` file with valid entries

### Compile and Run:

```bash
javac src/StockPrice_Q2.java
java -cp src StockPrice_Q2
````

Make sure `stocks.csv` is placed in the correct path (`src/stocks.csv`) relative to your execution context.

## ✅ Sample Output

```
pool-1-thread-1 processing: [Pair{key=TCS, value=3300.25}]
pool-1-thread-2 processing: [Pair{key=INFY, value=1450.50}]
...

Final Processed List
Pair{key=TCS, value=3300.25}
Pair{key=INFY, value=1450.50}
...
```

## 📌 Notes

* Thread pool size is fixed to 10.
* Output may vary due to the non-deterministic nature of thread execution.
* Proper exception handling is implemented during file reading.

## 📚 Topics Covered

* Multithreading and concurrency
* Functional programming in Java
* File parsing
* Data structures (generic pairs, lists)
* Parallel processing and performance optimization


```
