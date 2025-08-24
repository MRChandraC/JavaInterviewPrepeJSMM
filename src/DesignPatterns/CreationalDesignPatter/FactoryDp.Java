/*
Define an interface for creating objects, but subclasses decide which class to instantiate.
Used in frameworks (Spring internally uses factories).
*/


/**
 * Factory Method Example - Notification
 * 
 * Use Case: Depending on user preference, create Email or SMS notification dynamically.
 */

// Product interface
interface Notification {
    void notifyUser();
}

// Concrete Products
class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

// Factory Class
class NotificationFactory {
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException("Unknown Notification Type");
    }
}

//  Main class
public class FactoryExample {
    public static void main(String[] args) {
        Notification n1 = NotificationFactory.createNotification("EMAIL");
        n1.notifyUser();

        Notification n2 = NotificationFactory.createNotification("SMS");
        n2.notifyUser();
    }
}
