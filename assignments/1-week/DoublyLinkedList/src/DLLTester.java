public class DLLTester {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addToHead("C");
        list.addToTail("O");
        list.addToTail("M");
        list.addToTail("P");
        list.addToTail("U");
        list.addToTail("T");
        list.addToTail("E");
        list.printContents();
        list.addToHead("M");
        list.printContents();
        list.addToTail("R");
        list.printContents();
        list.removeHead();
        list.printContents();
        list.removeTail();
        list.insertBefore("M", "P");
        list.printContents();
        list.insertBefore("H", "M");
        list.printContents();
        list.insertBefore("B", "A");
        list.printContents();
        list.insertBefore("C", "P");
        list.printContents();
        list.insertAfter("L", "M");
        list.printContents();
        list.removeItem("M");
        list.printContents();
        list.removeItem("G");
        list.printContents();
        list.moveToHead("P");
        list.printContents();
        list.moveToTail("L");
        list.printContents();
    }
}
