import java.util.ArrayList;

public class TernaryHeapTester {

    private static int randomNumber() {
        return (int) Math.floor(Math.random() * 1000);
    }

    public static void main(String[] args) {
        int N = 100;
        TernaryHeap<Integer> pq = new TernaryHeap<>(N);
        ArrayList<Integer> keyUsed = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int randKey = randomNumber();
            while (keyUsed.contains(randKey))
                randKey = randomNumber();
            pq.insert(randKey);
            keyUsed.add(randKey);
        }
        pq.printContents();
        for (int i = 0; i < N; i++) {
            System.out.println(pq.delMax());
        }
    }
}
