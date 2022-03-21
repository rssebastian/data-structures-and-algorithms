public class TernaryHeap<Key extends Comparable<Key>> {
    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1..N] with pq[0] unused

    public TernaryHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N + 1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }

    public void printContents() {
        int counter = 0;
        for (Key el : pq) {
            System.out.println(counter++ + " " + el);
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less((k + 1) / 3, k)) {
            exch(k, (k + 1) / 3);
            k = (k + 1) / 3;
        }
    }

    private void sink(int k) {
        while (3 * k - 1 <= N) {
            int j = 3 * k - 1;
            if (j < N && less(j, j + 1))
                j++;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }
}
