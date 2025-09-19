package NoContest;

import java.util.ArrayList;
import java.util.Scanner;

public class StingyCandyman {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ar = sc.nextLine().split(" ");
        int[] base = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 9; i >= 2; i--) {
                try {
                    base[j] = Integer.parseInt(ar[j], i);
                    base[j] = i;
                } catch (Exception e) {
                    break;
                }
            }
        }
        ArrayList<String>[] b = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            b[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            b[base[i]].add(ar[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
    }
}
