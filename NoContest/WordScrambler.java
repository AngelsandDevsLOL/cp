package NoContest;

import java.util.*;

public class WordScrambler {
    public static TreeSet<String> tSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        tSet.add(x);
        permutations(x, 0, 1);
        for (String s : tSet) {
            System.out.println(s);
        }
    }

    public static void permutations(String str, int x, int y) {
        if (y > str.length() - 1) {
            x++;
            y = x + 1;
        }
        if (x >= str.length() - 1) {
            return;
        }
        permutations(str, x, y + 1);
        String firstPhrase = str.substring(0, x);
        String firstWord = str.substring(x, x + 1);
        String between = str.substring(x + 1, y);
        String secondWord = str.substring(y, y + 1);
        String secondPhrase = str.substring(y + 1);
        str = firstPhrase + secondWord + between + firstWord + secondPhrase;
        tSet.add(str);
        permutations(str, x + 1, x + 2);
    }
}