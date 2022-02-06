import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    private DoubleNode<Item> head, tail;

    public DoubleNode<Item> getHead() {
        return head;
    }

    public DoubleNode<Item> getTail() {
        return tail;
    }

    public void addToHead(Item item) {
        DoubleNode<Item> newNode = new DoubleNode<>(item, null, null);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.setPrev(newNode);
            head = newNode;
        }
    }

    public Iterator<Item> iterator() {
        return new DLLIterator<Item>(this);
    }

    private class DoubleNode<Item> {
        Item item;
        DoubleNode<Item> prev, next;

        public DoubleNode(Item item, DoubleNode<Item> prev, DoubleNode<Item> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Item getItem() {
            return this.item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public DoubleNode<Item> getPrev() {
            return this.prev;
        }

        public void setPrev(DoubleNode<Item> prev) {
            this.prev = prev;
        }

        public DoubleNode<Item> getNext() {
            return this.next;
        }

        public void setNext(DoubleNode<Item> next) {
            this.next = next;
        }
    }

    public class DLLIterator<Item> implements Iterator<Item> {
        private DoubleNode<Item> current;

        // Start iterating from the head of the DLL
        public DLLIterator(DoublyLinkedList<Item> list) {
            current = list.getHead();
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.getItem();
            current = current.getNext();
            return item;
        }
    }
}
