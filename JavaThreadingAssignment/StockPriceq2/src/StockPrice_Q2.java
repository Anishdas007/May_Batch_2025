package StockPriceq2.src;
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

public class StockPrice_Q2 {

  public static void ReadFile (String path,List<Pair<String, Float>> rawList){
      try{
          BufferedReader br = new BufferedReader(new FileReader(path));
          while (br.readLine()!=null) {
              String line= br.readLine();
              String[] parts = line.split(",");
              String stock = parts[0].trim();
              String priceStr = parts[1].trim();
              float price = Float.parseFloat(priceStr);
              rawList.add(new Pair<>(stock, price));
          }
      }catch (Exception e){
          System.out.println(e);
      }
   }

   public static List<Pair<String,Float>> process(List<Pair<String,Float>>rawList){
       int batchSize = (int) Math.ceil(rawList.size() / 10.0);
       ExecutorService executor = Executors.newFixedThreadPool(10);
       List<CompletableFuture<List<Pair<String, Float>>>> futures = new ArrayList<>();

       for (int i = 0; i < rawList.size(); i += batchSize) {
           int start = i;
           int end = Math.min(i + batchSize, rawList.size());
           List<Pair<String, Float>> batch = rawList.subList(start, end);
           CompletableFuture<List<Pair<String, Float>>> future = CompletableFuture.supplyAsync(() -> {
               List<Pair<String, Float>> result = new ArrayList<>();
               for (Pair<String, Float> entry : batch) {
                   result.add(new Pair<>(entry.getKey(), entry.getValue()));
                   System.out.println(Thread.currentThread().getName() + " processing: " + result);
               }
               return result;
           }, executor);
           futures.add(future);
       }

       List<Pair<String, Float>> finalList = futures.stream()
               .map(CompletableFuture::join)
               .flatMap(List::stream)
               .collect(Collectors.toList());

       executor.shutdown();
       return finalList;
   }

   public static void main(String[] args) throws Exception {
       String path = "src/stocks.csv";
       List<Pair<String, Float>> rawList = new ArrayList<>();
       ReadFile(path,rawList);
       List<Pair<String,Float>>finalList=process(rawList);
       System.out.println("\nFinal Processed List");
       for (Pair<String, Float> entry : finalList) {
           System.out.println(entry);
       }
   }
}
