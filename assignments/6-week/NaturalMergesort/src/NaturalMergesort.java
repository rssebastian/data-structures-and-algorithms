public class NaturalMergesort {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList("MERGESORTEXAMPLE".toCharArray());
        sort(list1);
        System.out.println("--------------------------------------------------------------------------");
        LinkedList list2 = new LinkedList("ILOVEALGORITHMS".toCharArray());
        sort(list2);
    }

    private NaturalMergesort() {
    }

    public static void sort(LinkedList list) {
        int count = 1;
        list.printContents();
        while (!isSorted(list)) {
            System.out.println("Pass #" + count + ": ");
            mergedList(list);
            list.printContents();
            count++;
        }
    }

    private static void mergedList(LinkedList list) {
        LinkedList.Node lastTail = null;
        LinkedList.Node current = list.head;
        LinkedList.Node cursor1 = null;
        LinkedList.Node cursor2 = null;

        while (current != null) {
            cursor1 = current;
            current = findSublist(current);
            cursor2 = current;
            current = findSublist(current);
            if (lastTail == null) {
                list.head = mergeSublists(cursor1, cursor2);
                lastTail = list.head;
                while (lastTail.next != null) {
                    lastTail = lastTail.next;
                }
            } else {
                lastTail.next = mergeSublists(cursor1, cursor2);
                while (lastTail.next != null) {
                    lastTail = lastTail.next;
                }
            }
        }
    }

    private static LinkedList.Node findSublist(LinkedList.Node n) {
        boolean tailFound = false;
        LinkedList.Node tail = null;
        while (!tailFound) {
            if (n == null)
                return null;
            if (n.next == null || n.compareTo(n.next) > 0) {
                tail = n;
                n = n.next;
                tail.next = null;
                tailFound = true;
            } else if (n.next != null && n.compareTo(n.next) <= 0) {
                n = n.next;
            }
        }
        return n;
    }

    private static LinkedList.Node mergeSublists(LinkedList.Node cursor1, LinkedList.Node cursor2) {
        LinkedList.Node tempHead;
        if (cursor2 == null)
            return cursor1;
        if (cursor1.compareTo(cursor2) <= 0) {
            tempHead = cursor1;
            cursor1 = cursor1.next;
        } else {
            tempHead = cursor2;
            cursor2 = cursor2.next;
        }
        LinkedList.Node tempCurrent = tempHead;
        while (cursor1 != null && cursor2 != null) {
            if (cursor1.compareTo(cursor2) <= 0) {
                tempCurrent.next = cursor1;
                tempCurrent = tempCurrent.next;
                cursor1 = cursor1.next;
            } else {
                tempCurrent.next = cursor2;
                tempCurrent = tempCurrent.next;
                cursor2 = cursor2.next;
            }
        }
        if (cursor1 == null) {
            tempCurrent.next = cursor2;
        } else {
            tempCurrent.next = cursor1;
        }
        return tempHead;
    }

    static boolean isSorted(LinkedList list) {
        LinkedList.Node current = list.head;
        while (current != null && current.next != null) {
            if (current.compareTo(current.next) > 0)
                return false;
            current = current.next;
        }
        return true;
    }

}

// TEST CASE OUTPUT
// M -> E -> R -> G -> E -> S -> O -> R -> T -> E -> X -> A -> M -> P -> L -> E
// Pass #1:
// E -> M -> R -> E -> G -> S -> E -> O -> R -> T -> X -> A -> L -> M -> P -> E
// Pass #2:
// E -> E -> G -> M -> R -> S -> A -> E -> L -> M -> O -> P -> R -> T -> X -> E
// Pass #3:
// A -> E -> E -> E -> G -> L -> M -> M -> O -> P -> R -> R -> S -> T -> X -> E
// Pass #4:
// A -> E -> E -> E -> E -> G -> L -> M -> M -> O -> P -> R -> R -> S -> T -> X
// --------------------------------------------------------------------------
// I -> L -> O -> V -> E -> A -> L -> G -> O -> R -> I -> T -> H -> M -> S
// Pass #1:
// E -> I -> L -> O -> V -> A -> G -> L -> O -> R -> H -> I -> M -> S -> T
// Pass #2:
// A -> E -> G -> I -> L -> L -> O -> O -> R -> V -> H -> I -> M -> S -> T
// Pass #3:
// A -> E -> G -> H -> I -> I -> L -> L -> M -> O -> O -> R -> S -> T -> V