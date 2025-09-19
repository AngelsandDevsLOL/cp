package AlphaStar;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class code {
    public static long ans = 0;
    public static void main (String[] args) {
        recursion(0, new int[21]);
        System.out.println(ans / Math.pow(2, 21));
    }
    public static void recursion (int ind, int[] prev) {
        if (ind == 21) {
            ans += 1;
            return;
        } else if (ind >= 3 && prev[ind - 1] == 1 && prev[ind - 2] == 1 && prev[ind - 3] == 1) {
            ans += Math.pow(2, 21 - ind);
            return;
        } else if (ind >= 1 && prev[ind - 1] == 2) {
            prev[ind] = 1;
            recursion(ind + 1, prev);
        } else {
            prev[ind] = 1;
            recursion(ind + 1, prev); // h
            prev[ind] = 2;
            recursion(ind + 1, prev); // t
        }

    }
}
