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

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public Node removeFirst() {
        Node temp;
        if (head == null) {
            return null;
        }
        temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (tail == null) {
            return null;
        }
        return temp;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " , ");
            temp = temp.next;
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
        linkedListExample.append(20);
        linkedListExample.removeFirst();
        linkedListExample.printList();
    }
}
