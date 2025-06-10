class Bridge {
    private boolean isTokenAtCityB = true; // Token starts at City B
    private boolean bridgeInUse = false;
    private int waitingCityA = 0;
    private int waitingCityB = 0;
    private boolean hasToken = true; // Represents availability of the single token

    public synchronized void requestToCross(String city, String personName) throws InterruptedException {
        if (city.equals("CityA")) {
            waitingCityA++;
            while (bridgeInUse || isTokenAtCityB || !hasToken) {
                wait();
            }
            waitingCityA--;
        } else { // CityB
            waitingCityB++;
            while (bridgeInUse || !isTokenAtCityB || !hasToken) {
                wait();
            }
            waitingCityB--;
        }

        bridgeInUse = true;
        hasToken = false;
        System.out.println(personName + " from " + city + " is crossing the bridge...");
    }

    public synchronized void doneCrossing(String city, String personName) {
        bridgeInUse = false;
        isTokenAtCityB = city.equals("CityA"); // If person came from A, token moves to B
        hasToken = true;

        System.out.println(personName + " has crossed the bridge. Token is now at " +
                (isTokenAtCityB ? "City B" : "City A"));

        // Notify all waiting threads (like notifyAll to prevent deadlocks)
        notifyAll();
    }
}

class Person extends Thread {
    private final String name;
    private final String fromCity;
    private final Bridge bridge;

    public Person(String name, String fromCity, Bridge bridge) {
        this.name = name;
        this.fromCity = fromCity;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        try {
            bridge.requestToCross(fromCity, name);
            Thread.sleep(1000); // Simulate crossing time
            bridge.doneCrossing(fromCity, name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bridge bridge = new Bridge();

        // Sample population from both cities
        Thread[] people = {
                new Person("Alice", "CityB", bridge),
                new Person("Bob", "CityB", bridge),
                new Person("Charlie", "CityA", bridge),
                new Person("David", "CityA", bridge),
                new Person("Eva", "CityB", bridge),
                new Person("Frank", "CityA", bridge)
        };

        for (Thread person : people) {
            person.start();
        }
    }
}
