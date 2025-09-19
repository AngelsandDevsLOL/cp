package ECOO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WordSearch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        char[][] puzzle = new char[r][c];
        ArrayList<Pair>[] aList = new ArrayList[26];
        for (int i = 0; i < r; i++) {
            puzzle[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < c; j++) {
                aList[puzzle[i][j] - 65].add(new Pair(i,j));
            }
        }
        HashSet<String> hSet = new HashSet<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String word = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= 65 && word.charAt(j) <= 91) {
                    sb.append(word.charAt(j));
                }
            }
            hSet.add(sb.toString());
        }

    }
    public static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
