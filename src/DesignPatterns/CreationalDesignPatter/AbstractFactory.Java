// Factory of Factories → Provides an interface for creating families of related objects without specifying their concrete classes.
// Instead of directly instantiating, client code asks the factory to produce objects.

// ---------- Product Interfaces ----------
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

// ---------- Concrete Products ----------
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a Windows-style Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Windows-style Checkbox");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Rendering a Mac-style Button");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a Mac-style Checkbox");
    }
}

// ---------- Abstract Factory ----------
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// ---------- Concrete Factories ----------
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// ---------- Client Code ----------
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Assume we detect OS = Windows
        GUIFactory factory = new WindowsFactory();
        // If Mac: GUIFactory factory = new MacFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}
