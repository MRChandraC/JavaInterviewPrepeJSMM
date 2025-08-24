package Java8Features;

public class AnonymousClassExample {
    public static void main(String[] args) {
        // Runnable is a functional interface with run() method
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running using Anonymous Class!");
            }
        };

        // Start thread with our anonymous class implementation
        Thread thread = new Thread(task);
        thread.start();
    }
}
