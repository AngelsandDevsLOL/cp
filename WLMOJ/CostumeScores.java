package WLMOJ;

import java.util.Scanner;

public class CostumeScores {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int count = 1;
        int largest = s;
        int smallest = s;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x > s) count++;
            if (x > largest) largest = x;
            if (x < smallest) smallest = x;
        }
        System.out.println(count);
        System.out.println(largest + " " + smallest);
    }
}
