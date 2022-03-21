import java.util.ArrayList;

public class TernaryHeapsortTester {

    private static int randomNumber() {
        return (int) Math.floor(Math.random() * 1000);
    }

    public static void main(String[] args) {
        int N = 100;
        int[] arr = new int[N];
        ArrayList<Integer> keyUsed = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int randKey = randomNumber();
            while (keyUsed.contains(randKey))
                randKey = randomNumber();
            arr[i] = randKey;
            keyUsed.add(randKey);
        }
        TernaryHeapsort.sort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}

// TEST CASE OUTPUT
// 2
// 11
// 12
// 18
// 23
// 51
// 56
// 76
// 93
// 94
// 101
// 122
// 124
// 132
// 135
// 148
// 162
// 164
// 169
// 186
// 188
// 195
// 198
// 202
// 203
// 209
// 213
// 214
// 217
// 218
// 220
// 233
// 248
// 252
// 257
// 263
// 279
// 280
// 282
// 288
// 292
// 316
// 360
// 373
// 374
// 409
// 423
// 428
// 472
// 474
// 493
// 515
// 526
// 528
// 530
// 544
// 555
// 556
// 562
// 567
// 581
// 607
// 617
// 627
// 628
// 629
// 639
// 642
// 657
// 668
// 670
// 671
// 677
// 719
// 725
// 728
// 737
// 740
// 753
// 773
// 779
// 782
// 794
// 805
// 808
// 846
// 868
// 869
// 879
// 882
// 896
// 918
// 921
// 928
// 937
// 938
// 947
// 953
// 982
// 989
