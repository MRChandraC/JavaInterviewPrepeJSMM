//A creational design pattern that allows you to create duplicate objects (clones) while keeping performance in mind.
//Instead of creating objects with new every time, you clone existing objects (prototypes).
//Used when object creation is costly (e.g., loading data from DB, parsing config, network calls).

// Step 1: Prototype interface
interface Prototype extends Cloneable {
    Prototype clone(); // Cloning contract
}

// Step 2: Concrete Prototype (e.g., Document)
class Document implements Prototype {
    private String title;
    private String content;
    private String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Implement clone()
    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // Getters/Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Document [title=" + title + ", content=" + content + ", author=" + author + "]";
    }
}

// Step 3: Client code
public class PrototypePatternDemo {
    public static void main(String[] args) {
        // Create an original document (expensive operation simulated)
        Document original = new Document("Design Patterns", "Prototype Pattern Content", "Chandra");

        // Clone the original document
        Document copy1 = original.clone();
        copy1.setAuthor("Alice");  // Change only author

        Document copy2 = original.clone();
        copy2.setTitle("Cloned Doc - Prototype"); // Change only title

        // Print all
        System.out.println("Original: " + original);
        System.out.println("Copy 1:   " + copy1);
        System.out.println("Copy 2:   " + copy2);
    }
}
