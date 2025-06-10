class SharedResource {
    private int data;
    private boolean isChanged = false;
    public synchronized void Even(int value) throws InterruptedException {
        while (isChanged) {
            wait();
        }
        data = value;
        isChanged = true;
        System.out.println("even: " + data);
        notify();
    }
    public synchronized void Odd() throws InterruptedException {
        while (!isChanged) {
            wait();
        }
        data+=1;
        System.out.println("Odd: " + data);
        isChanged = false;
        notify();
    }
}

public class EvenOdd_q1 {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread Even = new Thread(() -> {
            try {
                for (int i = 0; i <= 20; i+=2) {
                    resource.Even(i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread Odd = new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    resource.Odd();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Even.start();
        Odd.start();
    }
}