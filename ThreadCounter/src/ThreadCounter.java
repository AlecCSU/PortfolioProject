public class ThreadCounter {
    public static void main(String[] args) {
        // Create the first thread to count up to 20
        Thread countUpThread = new Thread(new CountUp());
        // Create the second thread to count down to 0
        Thread countDownThread = new Thread(new CountDown());

        // Start the count-up thread
        countUpThread.start();

        try {
            // Wait for the count-up thread to finish before starting count-down
            countUpThread.join();
            countDownThread.start();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

// Runnable to count up from 0 to 20
class CountUp implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 20; i++) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(500); // Sleep to simulate work being done
            } catch (InterruptedException e) {
                System.out.println("CountUp interrupted: " + e.getMessage());
            }
        }
    }
}

// Runnable to count down from 20 to 0
class CountDown implements Runnable {
    @Override
    public void run() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(500); // Sleep to simulate work being done
            } catch (InterruptedException e) {
                System.out.println("CountDown interrupted: " + e.getMessage());
            }
        }
    }
}
