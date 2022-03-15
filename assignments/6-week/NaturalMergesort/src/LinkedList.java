public class LinkedList {
    Node head, tail;
    int size;

    LinkedList() {
    }

    LinkedList(char[] arr) {
        for (char item : arr) {
            add(item);
        }
    }

    public void printContents() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node current = head;
        while (current != null) {
            if (current.getNext() == null) {
                System.out.print(current.getData());
            } else {
                System.out.print(current.getData() + " -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public void add(char item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    class Node implements Comparable<Node> {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }

        char getData() {
            return this.data;
        }

        Node getNext() {
            return this.next;
        }

        void setNext(Node next) {
            this.next = next;
        }

        public int compareTo(Node n) {
            return Character.compare(this.data, n.getData());
        }
    }

    public static void main(String[] args) {

    }
}
