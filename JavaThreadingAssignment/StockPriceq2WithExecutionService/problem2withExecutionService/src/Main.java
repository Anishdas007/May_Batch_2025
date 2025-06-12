import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class Pair<T, S> {
    T key;
    S value;

    Pair(T key, S value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair{" + "key=" + key + ", value=" + value + '}';
    }
}

public class Main {

    public static void ReadFile(String path, List<Pair<String, Float>> rawList) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String stock = parts[0].trim();
                float price = Float.parseFloat(parts[1].trim());
                rawList.add(new Pair<>(stock, price));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public static List<Pair<String, Float>> process(List<Pair<String, Float>> rawList) {
        int batchSize = (int) Math.ceil(rawList.size() / 10.0);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<List<Pair<String, Float>>> completionService = new ExecutorCompletionService<>(executor);

        int submittedTasks = 0;
        for (int i = 0; i < rawList.size(); i += batchSize) {
            int start = i;
            int end = Math.min(i + batchSize, rawList.size());
            List<Pair<String, Float>> batch = rawList.subList(start, end);

            completionService.submit(() -> {
                List<Pair<String, Float>> result = new ArrayList<>();
                for (Pair<String, Float> entry : batch) {
                    result.add(new Pair<>(entry.getKey(), entry.getValue()));
                    System.out.println(Thread.currentThread().getName() + " processing: " + result);
                }
                return result;
            });

            submittedTasks++;
        }

        List<Pair<String, Float>> finalList = new ArrayList<>();
        try {
            for (int i = 0; i < submittedTasks; i++) {
                Future<List<Pair<String, Float>>> future = completionService.take(); // waits for next completed batch
                finalList.addAll(future.get()); // get() won't block long here
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Task execution failed: " + e);
        }

        executor.shutdown();
        return finalList;
    }

    public static void main(String[] args) {
        String path = "src/stocks.csv";
        List<Pair<String, Float>> rawList = new ArrayList<>();
        ReadFile(path, rawList);

        List<Pair<String, Float>> finalList = process(rawList);
        System.out.println("\nFinal Processed List");
        for (Pair<String, Float> entry : finalList) {
            System.out.println(entry);
        }
    }
}
