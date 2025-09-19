package COCI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Place {
    public static HashMap<Integer, Integer> hMap = new HashMap<>();
    public static int[] wages;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] aList = new ArrayList[n + 1];
        wages = new int[n + 1];
        for (int i = 0; i < n; i++) {
            aList[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int wageInput = sc.nextInt();
            int parent = sc.nextInt();
        }
    }
}
