public class RBBSTTester {
    public static void main(String[] args) {
        RedBlackBST<Integer, Integer> rb = new RedBlackBST<Integer, Integer>();
        for (int i = 1; i <= 60; i++) {
            rb.put(i, i);
        }
        System.out.println("Printing Level Order of RB BST...");
        rb.printLevelOrder();
        System.out.println("----------------------------------");

        for (int i = 1; i <= 20; i++) {
            rb.delete(i);
        }

        System.out.println("Printing Level Order of RB BST after deletions...");
        rb.printLevelOrder();
        System.out.println("----------------------------------");
    }
}

// TEST CASE OUTPUT
// Printing Level Order of RB BST...
// 32, Red: false
// 16, Red: true
// 48, Red: false
// 8, Red: false
// 24, Red: false
// 40, Red: true
// 56, Red: false
// 4, Red: false
// 12, Red: false
// 20, Red: false
// 28, Red: false
// 36, Red: false
// 44, Red: false
// 52, Red: true
// 58, Red: false
// 2, Red: false
// 6, Red: false
// 10, Red: false
// 14, Red: false
// 18, Red: false
// 22, Red: false
// 26, Red: false
// 30, Red: false
// 34, Red: false
// 38, Red: false
// 42, Red: false
// 46, Red: false
// 50, Red: false
// 54, Red: false
// 57, Red: false
// 60, Red: false
// 1, Red: false
// 3, Red: false
// 5, Red: false
// 7, Red: false
// 9, Red: false
// 11, Red: false
// 13, Red: false
// 15, Red: false
// 17, Red: false
// 19, Red: false
// 21, Red: false
// 23, Red: false
// 25, Red: false
// 27, Red: false
// 29, Red: false
// 31, Red: false
// 33, Red: false
// 35, Red: false
// 37, Red: false
// 39, Red: false
// 41, Red: false
// 43, Red: false
// 45, Red: false
// 47, Red: false
// 49, Red: false
// 51, Red: false
// 53, Red: false
// 55, Red: false
// 59, Red: true
// ----------------------------------
// Printing Level Order of RB BST after deletions...
// 40, Red: false
// 32, Red: false
// 48, Red: false
// 28, Red: false
// 36, Red: false
// 44, Red: false
// 56, Red: false
// 24, Red: true
// 30, Red: false
// 34, Red: false
// 38, Red: false
// 42, Red: false
// 46, Red: false
// 52, Red: true
// 58, Red: false
// 22, Red: false
// 26, Red: false
// 29, Red: false
// 31, Red: false
// 33, Red: false
// 35, Red: false
// 37, Red: false
// 39, Red: false
// 41, Red: false
// 43, Red: false
// 45, Red: false
// 47, Red: false
// 50, Red: false
// 54, Red: false
// 57, Red: false
// 60, Red: false
// 21, Red: false
// 23, Red: false
// 25, Red: false
// 27, Red: false
// 49, Red: false
// 51, Red: false
// 53, Red: false
// 55, Red: false
// 59, Red: true