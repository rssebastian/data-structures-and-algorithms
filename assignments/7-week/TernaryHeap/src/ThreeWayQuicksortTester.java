public class ThreeWayQuicksortTester {
    private static double randomNumber() {
        return Math.floor(Math.random() * 1000);
    }

    public static void main(String[] args) {

        final int inputSize = (int) Math.pow(10, 6);
        Double[] inputs = new Double[inputSize];
        for (int i = 0; i < inputSize; i++) {
            inputs[i] = randomNumber();
        }
        for (int i = 11; i < 31; i++) {
            long startTime = System.currentTimeMillis();
            ThreeWayQuicksort.sort(inputs, i);
            long endTime = System.currentTimeMillis();
            System.out.println(i + " Total execution time: " + (endTime - startTime));
        }
    }
}
