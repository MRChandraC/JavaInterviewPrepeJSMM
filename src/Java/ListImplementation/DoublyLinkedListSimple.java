package Java.ListImplementation;


/*
LinkedList stores data with a pointer to the next node only, while Doubly LinkedList stores pointers to both next and previous nodes.
In LinkedList, traversal is possible only forward, but in Doubly LinkedList, traversal is possible both forward and backward.
Insertion/Deletion in LinkedList requires adjusting only the next pointer, while in Doubly LinkedList both next and prev pointers must be updated.
Doubly LinkedList uses more memory (extra prev pointer per node) but provides faster operations from both ends, unlike LinkedList.
 */
class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Insert at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insert at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    // Display forward
    void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    void displayBackward() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {  // go to last node
            temp = temp.next;
        }
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class DoublyLinkedListSimple {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.displayForward();   // Forward: 10 20 30

        dll.insertAtBeginning(5);
        dll.displayForward();   // Forward: 5 10 20 30

        dll.displayBackward();  // Backward: 30 20 10 5
    }
}
