import edu.princeton.cs.algs4.StdRandom;

public class ThreeWayQuicksort {
    private ThreeWayQuicksort() {
    }

    private static int partition(Comparable[] a, int lo, int hi, int pivot) {
        int i = lo, j = hi + 1;
        while (true) {
            while (less(a[++i], a[pivot]))
                if (i == hi)
                    break;
            while (less(a[pivot], a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a, int cutoff) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, cutoff);
    }

    private static void sort(Comparable[] a, int lo, int hi, int cutoff) {
        if (hi <= lo + cutoff) {
            insertionSort(a, lo, hi);
            return;
        }

        int pivot = getPivot(a, lo, hi);
        int j = partition(a, lo, hi, pivot);
        sort(a, lo, j - 1, cutoff);
        sort(a, j + 1, hi, cutoff);
    }

    private static int getPivot(Comparable[] a, int lo, int hi) {
        int center = (lo + hi) / 2;

        if (less(a[center], a[lo]))
            exch(a, lo, center);

        if (less(a[hi], a[lo]))
            exch(a, lo, hi);

        if (less(a[hi], a[center]))
            exch(a, center, hi);

        exch(a, center, hi);
        return hi;
    }

    private static void insertionSort(Comparable[] a, int lo, int hi) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else
                    break;
            }
        }
    }

    private static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
