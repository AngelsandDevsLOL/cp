package Random;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BadNews {
    public static ArrayList<Pair>[] aList = new ArrayList[26];
    public static String[] list;
    public static int n;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int q = sc.nextInt();
        list = new String[q];
        for (int i = 0; i < 26; i++) {
            aList[i] = new ArrayList<>();
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                aList[input[j].charAt(0)-97].add(new Pair(i, j));
            }
        }
        for (int i = 0; i < q; i++) {
            list[i] = sc.nextLine();
            for (int j = 0; !list[i].equals("") && j < aList[list[i].charAt(0)-97].size(); j++) {
                recursion(list[i], aList[list[i].charAt(0) - 97].get(j).x, aList[list[i].charAt(0) - 97].get(j).y, i);
            }
            if (list[i].equals("")) System.out.println("good puzzle!");
            else System.out.println("bad puzzle!");
        }
    }
    public static void recursion (String str, int x, int y, int z) {
        if (str.length() <= 1) {
            list[z] = "";
            return;
        } else {
            int find = str.charAt(1) - 97;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if ((i != 0 || j != 0) && x + i >= 0 && x + i < n && y + j >= 0 && y + j < n) {
                        if (aList[find].contains(new Pair(x + i, y + j))) {
                            recursion(str.substring(1), x + i, y + j, z);
                        }
                    }
                }
            }
        }
    }
    static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
