class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}

public class LinkedListExample {
    Node head;
    Node tail;
    int length;

    public LinkedListExample(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Value in PrintList is" + " : " + temp.value);
            temp = head.next;
        }
    }

    public void getTail() {
        System.out.println("Value of head is" + " : " + head.value);
    }

    public void getHead() {
        System.out.println("Value of tail is" + " : " + tail.value);
    }

    public static void main(String[] args) {
        LinkedListExample linkedListExample = new LinkedListExample(4);
        System.out.println("Length of the LinkedList is" + " : " + linkedListExample.length);
        linkedListExample.printList();
        linkedListExample.getHead();
        linkedListExample.getTail();
    }
}
