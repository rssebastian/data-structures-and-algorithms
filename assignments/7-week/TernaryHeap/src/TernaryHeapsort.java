public class TernaryHeapsort {
    public static void sort(int[] a) {
        int N = a.length;
        // Build heap bottom-up
        for (int k = N / 3 - 1; k >= 0; k--)
            sink(a, k, N);
        // Move max to end, sink so new max rises
        while (N > 0) {
            exch(a, 0, N - 1);
            sink(a, 0, --N);
        }
    }

    private static void sink(int[] a, int k, int N) {
        // Check left child
        while (3 * k + 1 < N) {
            int j = findLargestChild(a, 3 * k + 1, 3 * k + 2, 3 * k + 3, N);
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    private static int findLargestChild(int[] a, int i, int j, int k, int N) {

        if (j < N && a[i] < a[j]) {
            if (k < N && a[j] < a[k])
                return k;
            else
                return j;
        }
        if (k < N && a[i] < a[k])
            return k;
        return i;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
