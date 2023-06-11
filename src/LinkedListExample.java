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

    public Node removeFromFirst() {
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

    public Node removeFromLast() {
        if (length == 0) {
            return null;
        }
        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        if (index == 0) {
            removeFromFirst();
        }
        if (index == length - 1) {
            removeFromLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        tail = head;
        head = previous;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length) {
            return false;
        }
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
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
        LinkedListExample linkedListExample = new LinkedListExample(1);
        linkedListExample.append(2);
        linkedListExample.append(3);
        linkedListExample.append(4);
        System.out.println("Length of the LinkedList is" + " : " + linkedListExample.length);
        linkedListExample.getHead();
        linkedListExample.getTail();
        linkedListExample.removeFromFirst();
        linkedListExample.printList();
        System.out.println(System.lineSeparator() + "LinkedList Value at Index" + " : " + linkedListExample.get(2).value);
        System.out.println("Boolean Value for the set method" + " " + linkedListExample.set(2, 5));
        linkedListExample.prepend(10);
        linkedListExample.insert(2, 20);
        linkedListExample.printList();
        System.out.println(System.lineSeparator() + "Elements Removed from the last" + " " + linkedListExample.removeFromLast().value);
        System.out.println(System.lineSeparator() + "Elements Removed from the LinkedList" + " " + linkedListExample.remove(2).value);
        linkedListExample.reverse();
        linkedListExample.printList();
    }
}
