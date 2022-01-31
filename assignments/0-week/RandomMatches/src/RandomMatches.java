// Write a BinarySearch client that takes an int value T as
// command-line argument and runs T trials of the following experiment for N = 10^3, 10^4,
// 10^5, and 10^6: generate two arrays of N randomly generated positive six-digit int values,
// and find the number of values that appear in both arrays. Print a table giving the average
// value of this quantity over the T trials for each value of N.

import edu.princeton.cs.algs4.BinarySearch;
import java.util.Scanner;
import java.util.Arrays;

public class RandomMatches {
    protected static final int[][] data = { new int[(int) Math.pow(10, 3)],
            new int[(int) Math.pow(10, 3)],
            new int[(int) Math.pow(10, 4)],
            new int[(int) Math.pow(10, 4)],
            new int[(int) Math.pow(10, 5)],
            new int[(int) Math.pow(10, 5)],
            new int[(int) Math.pow(10, 6)],
            new int[(int) Math.pow(10, 6)]
    };
    private static int tenToThirdCount, tenToFourthCount, tenToFifthCount, tenToSixthCount;

    public static void runTrials(int T) {
        if (T <= 0) {
            System.out.println("T must be greater than 0 to run");
            System.exit(0);
        }

        fillArrays();
        System.out.printf("Running %d trial(s)...%n", T);

        // Runs T trials
        for (int i = 0; i < T; i++) {
            tenToThirdCount += calculateMatches(data[0], data[1]);
            tenToFourthCount += calculateMatches(data[2], data[3]);
            tenToFifthCount += calculateMatches(data[4], data[5]);
            tenToSixthCount += calculateMatches(data[6], data[7]);
        }

        // Takes the sum
        tenToThirdCount /= T;
        tenToFourthCount /= T;
        tenToFifthCount /= T;
        tenToSixthCount /= T;

        printTable();
    }

    // Helper method to populate the initial data
    private static void fillArrays() {
        for (int i = 0; i < data.length; i++) {
            // Fill Arrays
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = getRandomInt();
            }
            // Sort each array in ascending order once filled
            Arrays.sort(data[i]);
        }
    }

    // Helper method to return the number of matches in two arrays
    private static int calculateMatches(int[] arr1, int[] arr2) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (BinarySearch.indexOf(arr2, arr1[i]) > 0) {
                counter++;
            }
        }
        return counter;
    }

    // Helper method to create table display
    private static void printTable() {
        String linebreak = "---------------";
        final Object[][] table = new String[4][];
        table[0] = new String[] { "10^3", String.valueOf(tenToThirdCount) };
        table[1] = new String[] { "10^4", String.valueOf(tenToFourthCount) };
        table[2] = new String[] { "10^5", String.valueOf(tenToFifthCount) };
        table[3] = new String[] { "10^6", String.valueOf(tenToSixthCount) };
        System.out.println(linebreak);
        for (final Object[] row : table) {
            System.out.format("%10s%10s%n", row);
        }
        System.out.println(linebreak);
    }

    // Helper method to generate 6 digit integers
    private static int getRandomInt() {
        return (int) ((Math.random() * (1000000 - 100000)) + 100000);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please specify how many trials you would like to run: ");
        int numTrials = keyboard.nextInt();
        runTrials(numTrials);
    }
}

// TEST CASE OUTPUT
// Please specify how many trials you would like to run: 0
// T must be greater than 0 to run

// Please specify how many trials you would like to run: 1
// Running 1 trial(s)...
// ---------------
// 10^3 1
// 10^4 113
// 10^5 10743
// 10^6 670061
// ---------------
// Please specify how many trials you would like to run: 2
// Running 2 trial(s)...
// ---------------
// 10^3 2
// 10^4 107
// 10^5 10498
// 10^6 670502
// ---------------
// Please specify how many trials you would like to run: 5
// Running 5 trial(s)...
// ---------------
// 10^3 0
// 10^4 101
// 10^5 10440
// 10^6 671629
// ---------------
// Please specify how many trials you would like to run: 10
// Running 10 trial(s)...
// ---------------
// 10^3 0
// 10^4 113
// 10^5 10480
// 10^6 670160
// ---------------
// Please specify how many trials you would like to run: 50
// Running 50 trial(s)...
// ---------------
// 10^3 1
// 10^4 109
// 10^5 10408
// 10^6 670162
// ---------------
