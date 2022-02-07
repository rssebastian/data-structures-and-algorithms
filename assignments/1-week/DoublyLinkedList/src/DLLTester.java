public class DLLTester {
    public static void main(String[] args) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        String linebreak = "--------------------";
        list.addToHead("C");
        list.addToTail("O");
        list.addToTail("M");
        list.addToTail("P");
        list.addToTail("U");
        list.addToTail("T");
        list.addToTail("E");
        System.out.println(linebreak);
        System.out.println("1. Print the contents of the list: ");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("2. Insert M at the beginning of the list: ");
        list.addToHead("M");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("3. Insert R at the end: ");
        list.addToTail("R");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("4. Remove from the beginning: ");
        list.removeHead();
        list.printContents();
        System.out.println(linebreak);
        System.out.println("5. Remove from the end: ");
        list.removeTail();
        list.printContents();
        System.out.println(linebreak);
        System.out.println("6. Insert M before P: ");
        list.insertBefore("M", "P");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("7. Insert H before M: ");
        list.insertBefore("H", "M");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("8. Insert B before A: ");
        list.insertBefore("B", "A");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("9. Insert C after P: ");
        list.insertAfter("C", "P");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("10. Insert L after M: ");
        list.insertAfter("L", "M");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("11. Remove M ");
        list.removeItem("M");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("12. Remove G ");
        list.removeItem("G");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("13. Move P to the front of the list: ");
        list.moveToHead("P");
        list.printContents();
        System.out.println(linebreak);
        System.out.println("14. Move L to the end of the list: ");
        list.moveToTail("L");
        list.printContents();
    }
}

// TEST CASE OUTPUT
// C has been added as the head!
// O has been added to the tail!
// M has been added to the tail!
// P has been added to the tail!
// U has been added to the tail!
// T has been added to the tail!
// E has been added to the tail!
// --------------------
// 1. Print the contents of the list:
// C -> O -> M -> P -> U -> T -> E
// --------------------
// 2. Insert M at the beginning of the list:
// M has been added as the head!
// M -> C -> O -> M -> P -> U -> T -> E
// --------------------
// 3. Insert R at the end:
// R has been added to the tail!
// M -> C -> O -> M -> P -> U -> T -> E -> R
// --------------------
// 4. Remove from the beginning:
// M has been removed as head!
// C is the new head!
// C -> O -> M -> P -> U -> T -> E -> R
// --------------------
// 5. Remove from the end:
// R has been removed as tail!
// E is the new tail!
// C -> O -> M -> P -> U -> T -> E
// --------------------
// 6. Insert M before P:
// M has been inserted before P
// C -> O -> M -> M -> P -> U -> T -> E
// --------------------
// 7. Insert H before M:
// H has been inserted before M
// C -> O -> H -> M -> M -> P -> U -> T -> E
// --------------------
// 8. Insert B before A:
// B has been added to the tail!
// A not found, inserted B at the tail!
// C -> O -> H -> M -> M -> P -> U -> T -> E -> B
// --------------------
// 9. Insert C after P:
// C has been inserted after P
// C -> O -> H -> M -> M -> P -> C -> U -> T -> E -> B
// --------------------
// 10. Insert L after M:
// L has been inserted after M
// C -> O -> H -> M -> L -> M -> P -> C -> U -> T -> E -> B
// --------------------
// 11. Remove M
// C -> O -> H -> L -> M -> P -> C -> U -> T -> E -> B
// --------------------
// 12. Remove G
// Node not found, nothing to remove!
// C -> O -> H -> L -> M -> P -> C -> U -> T -> E -> B
// --------------------
// 13. Move P to the front of the list:
// P is the new head!
// P -> C -> O -> H -> L -> M -> C -> U -> T -> E -> B
// --------------------
// 14. Move L to the end of the list:
// L is the new tail!
// P -> C -> O -> H -> M -> C -> U -> T -> E -> B -> L