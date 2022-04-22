import edu.princeton.cs.algs4.SeparateChainingHashST;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SpellChecker {
    private static SeparateChainingHashST dictionary;
    public static void main(String[] args) throws FileNotFoundException {
        fillDictionary();
        Scanner userScan = new Scanner(System.in);
        System.out.println("Type & Enter a word below (or enter ^ to exit):");
        String userInput = userScan.nextLine().toLowerCase();
        while (!userInput.equals("^")) {
            if (dictionary.contains(userInput)){
                System.out.println("No mistakes found!");
            } else {
                ArrayList<String> options = gatherOptions(userInput);
                if (options.isEmpty()){
                    System.out.println("No suggestions found! Try again.");
                } else {
                    System.out.println("Did you mean:");
                    for (String word : options) {
                        System.out.println(word);
                    }
                }
            }
            System.out.println("Check another word? (or enter ^ to exit):");
            userInput = userScan.nextLine().toLowerCase();
        }
    }
    private static void fillDictionary() throws FileNotFoundException {
        // hash table size calculated using https://cseweb.ucsd.edu/~kube/cls/100/Lectures/lec16/lec16-8.html
        // next prime number after 20688 words * 1.3
        dictionary = new SeparateChainingHashST(26099);
        File sourceFile = new File("words.txt");
        Scanner wordScan = new Scanner(sourceFile);
        while (wordScan.hasNextLine()) {
            String word = wordScan.nextLine();
            dictionary.put(word, word);
        }
        wordScan.close();
    }
    private static ArrayList<String> gatherOptions(String input){
        ArrayList<String> options = new ArrayList<>();
        options.addAll(checkAddChar(input));
        options.addAll(checkRemoveChar(input));
        options.addAll(checkAdjChar(input));
        return options;
    }

    private static ArrayList<String> checkAddChar(String input){
        ArrayList<String> options = new ArrayList<>();
        for (char c='a'; c<='z'; c++){
            String wordToTry = input + String.valueOf(c);
            if (dictionary.contains(wordToTry)){
                options.add(wordToTry);
            }
            wordToTry = String.valueOf(c) + input;
            if (dictionary.contains(wordToTry)){
                options.add(wordToTry);
            }
        }
        return options;
    }

    private static ArrayList<String> checkRemoveChar(String input){
        ArrayList<String> options = new ArrayList<>();
        String wordToTry = input.substring(1);
        if (dictionary.contains(wordToTry)){
            options.add(wordToTry);
        }
        wordToTry = input.substring(0,input.length()-1);
        if (dictionary.contains(wordToTry)){
            options.add(wordToTry);
        }
        return options;
    }
    private static ArrayList<String> checkAdjChar(String input){
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i<input.length()-1; i++){
            char[] tempStr = input.toCharArray();
            char temp = tempStr[i];
            tempStr[i] = tempStr[i+1];
            tempStr[i+1] = temp;
            String wordToTry = new String(tempStr);
            if (dictionary.contains(wordToTry)){
                options.add(wordToTry);
            }
        }
        return options;
    }
}

/*TEST CASE OUTPUT
Type & Enter a word below (or enter ^ to exit):
dat
Did you mean:
data
date
at
Check another word? (or enter ^ to exit):
tructure
Did you mean:
structure
Check another word? (or enter ^ to exit):
nad
Did you mean:
ad
and
Check another word? (or enter ^ to exit):
algoirthms
No suggestions found! Try again.
Check another word? (or enter ^ to exit):
algoirthm
Did you mean:
algorithm
Check another word? (or enter ^ to exit):
^
*/