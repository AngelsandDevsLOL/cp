package USACO;

import java.util.ArrayList;
import java.util.Scanner;

public class CountingLiars {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> g = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            if (input[0].equals("L")) {
                g.add(Integer.valueOf(input[1]));
            } else {
                l.add(Integer.valueOf(input[1]));
            }
        }
        int min = n;
        for (int a : g) {
            min = Math.min(count(a, g, l), min);
        }
        for (int a : l) {
            min = Math.min(count(a, g, l), min);
        }
        System.out.println(min);
    }
    public static int count(int num, ArrayList<Integer> g, ArrayList<Integer> l) {
        int count = 0;
        for (int a : g) {
            if (num > a) count++;
        }
        for (int a : l) {
            if (num < a) count++;
        }
        return count;
    }
}
