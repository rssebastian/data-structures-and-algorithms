import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private DoubleNode<Item> head, tail;

    public DoubleNode<Item> getHead() {
        return head;
    }

    public DoubleNode<Item> getTail() {
        return tail;
    }

    public void printContents() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        DoubleNode<Item> current = head;
        while (current != null) {
            if (current.getNext() == null) {
                System.out.print(current.getItem());
            } else {
                System.out.print(current.getItem() + " -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public void addToHead(Item item) {
        DoubleNode<Item> newNode = new DoubleNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
        }
        System.out.println(item + " has been added as the head!");
    }

    public void addToTail(Item item) {
        DoubleNode<Item> newNode = new DoubleNode<>(item);
        if (tail == null) {
            tail = head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        System.out.println(item + " has been added to the tail!");
    }

    public DoubleNode<Item> removeHead() {
        DoubleNode<Item> oldHead = head;
        head = head.getNext();
        head.setPrev(null);
        System.out.println(oldHead.getItem() + " has been removed as head!");
        System.out.println(head.getItem() + " is the new head!");
        return oldHead;
    }

    public DoubleNode<Item> removeTail() {
        DoubleNode<Item> oldTail = tail;
        tail = tail.getPrev();
        tail.setNext(null);
        System.out.println(oldTail.getItem() + " has been removed as tail!");
        System.out.println(tail.getItem() + " is the new tail!");
        return oldTail;
    }

    public void insertBefore(Item item, Item node) {
        DoubleNode<Item> foundNode = find(node);
        if (foundNode != null) {
            DoubleNode<Item> newNode = new DoubleNode<>(item);
            newNode.setPrev(foundNode.getPrev());
            newNode.setNext(foundNode);
            foundNode.getPrev().setNext(newNode);
            foundNode.setPrev(newNode);
            System.out.println(item + " has been inserted before " + node);
        } else {
            addToTail(item);
            System.out.println(node + " not found, inserted " + item + " at the tail!");
        }
    }

    public void insertAfter(Item item, Item node) {
        DoubleNode<Item> foundNode = find(node);
        if (foundNode != null) {
            DoubleNode<Item> newNode = new DoubleNode<>(item);
            newNode.setPrev(foundNode);
            newNode.setNext(foundNode.getNext());
            foundNode.getNext().setPrev(newNode);
            foundNode.setNext(newNode);
            System.out.println(item + " has been inserted after " + node);
        } else {
            addToTail(item);
            System.out.println(node + " not found, inserted " + item + " at the tail!");
        }
    }

    public DoubleNode<Item> removeItem(Item item) {
        DoubleNode<Item> node = find(item);
        if (node == null) {
            System.out.println("Node not found, nothing to remove!");
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
        return node;
    }

    public void moveToHead(Item item) {
        DoubleNode<Item> node = find(item);
        if (node == null) {
            System.out.println("This item is not part of the list yet!");
        } else if (node.equals(head)) {
            System.out.println("This item is already the head!");
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(null);
            node.setNext(head);
            head.setPrev(node);
            head = node;
            System.out.println(item + " is the new head!");
        }
    }

    public void moveToTail(Item item) {
        DoubleNode<Item> node = find(item);
        if (node == null) {
            System.out.println("This item is not part of the list yet!");
        } else if (node.equals(tail)) {
            System.out.println("This item is already the tail!");
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(tail);
            node.setNext(null);
            tail.setNext(node);
            tail = node;
            System.out.println(item + " is the new tail!");
        }
    }

    public Iterator<Item> iterator() {
        return new DLLIterator();
    }

    private DoubleNode<Item> find(Item item) {
        DoubleNode<Item> current = head;
        while (current != null) {
            if (current.getItem().equals(item)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    private class DLLIterator implements Iterator<Item> {
        private DoubleNode<Item> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }
    }

    private class DoubleNode<T> {
        T item;
        DoubleNode<T> prev, next;

        public DoubleNode(T item) {
            this.item = item;
        }

        public T getItem() {
            return this.item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public DoubleNode<T> getPrev() {
            return this.prev;
        }

        public void setPrev(DoubleNode<T> prev) {
            this.prev = prev;
        }

        public DoubleNode<T> getNext() {
            return this.next;
        }

        public void setNext(DoubleNode<T> next) {
            this.next = next;
        }
    }
}
