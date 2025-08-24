/**
 * Singleton Example - Logger
 * 
 * Use Case: Only one logger should exist in the system to avoid multiple inconsistent loggers.
Singleton Pattern
Ensures only one instance of a class is created.
Global access point to that instance.
Used in logging, configuration, cache, thread pools.
 */
class Logger {

    // 1️ Private static instance
    private static Logger instance;

    // 2️ Private constructor (prevents object creation outside)
    private Logger() {}

    // 3️ Public static method to return single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(); // Lazy initialization
        }
        return instance;
    }

    // Example method
    public void log(String msg) {
        System.out.println("[LOG]: " + msg);
    }
}

//  Main class
public class SingletonExample {
    public static void main(String[] args) {
        // Both logger1 and logger2 will point to the SAME instance
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Starting Application...");
        logger2.log("Application Running...");

        System.out.println(logger1 == logger2); // true
    }
}
