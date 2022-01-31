// Develop a better implementation of F(N) that saves computed values in
// an array.

public class FibBetter {
    public static long[] results;

    public static long F(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N > 1) {
            results[0] = 0;
            results[1] = 1;
            int fillIdx = 2;
            while (fillIdx < results.length) {
                results[fillIdx] = results[fillIdx - 1] + results[fillIdx - 2];
                fillIdx++;
            }
        }
        return results[N];
    }

    public static void main(String[] args) {
        for (int N = 0; N < 100; N++) {
            results = new long[N + 1];
            System.out.println(N + " " + F(N));
        }

    }
}

// TEST CASE OUTPUT (Does not correct for long overflow)
// 0 0
// 1 1
// 2 1
// 3 2
// 4 3
// 5 5
// 6 8
// 7 13
// 8 21
// 9 34
// 10 55
// 11 89
// 12 144
// 13 233
// 14 377
// 15 610
// 16 987
// 17 1597
// 18 2584
// 19 4181
// 20 6765
// 21 10946
// 22 17711
// 23 28657
// 24 46368
// 25 75025
// 26 121393
// 27 196418
// 28 317811
// 29 514229
// 30 832040
// 31 1346269
// 32 2178309
// 33 3524578
// 34 5702887
// 35 9227465
// 36 14930352
// 37 24157817
// 38 39088169
// 39 63245986
// 40 102334155
// 41 165580141
// 42 267914296
// 43 433494437
// 44 701408733
// 45 1134903170
// 46 1836311903
// 47 2971215073
// 48 4807526976
// 49 7778742049
// 50 12586269025
// 51 20365011074
// 52 32951280099
// 53 53316291173
// 54 86267571272
// 55 139583862445
// 56 225851433717
// 57 365435296162
// 58 591286729879
// 59 956722026041
// 60 1548008755920
// 61 2504730781961
// 62 4052739537881
// 63 6557470319842
// 64 10610209857723
// 65 17167680177565
// 66 27777890035288
// 67 44945570212853
// 68 72723460248141
// 69 117669030460994
// 70 190392490709135
// 71 308061521170129
// 72 498454011879264
// 73 806515533049393
// 74 1304969544928657
// 75 2111485077978050
// 76 3416454622906707
// 77 5527939700884757
// 78 8944394323791464
// 79 14472334024676221
// 80 23416728348467685
// 81 37889062373143906
// 82 61305790721611591
// 83 99194853094755497
// 84 160500643816367088
// 85 259695496911122585
// 86 420196140727489673
// 87 679891637638612258
// 88 1100087778366101931
// 89 1779979416004714189
// 90 2880067194370816120
// 91 4660046610375530309
// 92 7540113804746346429
// 93 -6246583658587674878
// 94 1293530146158671551
// 96 -3659523366270331776
// 97 -8612576878699335103
// 98 6174643828739884737
// 99 -2437933049959450366
