package CCO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Snowflakes {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<String> set = new HashSet();
        for (int i = 0; i < n; i++) {
            int[] ar = new int[6];
            int smallest = 10000000;
            int ind = 0;
            int ind2 = 0;
            for (int j = 0; j < 6; j++) {
                ar[j] = scanner.nextInt();
                if (ar[j] < smallest) {smallest = ar[j]; ind = j;}
                else if (ar[j] == smallest) ind2 = j;
            }
            String x = (ar[ind]) + " " + ar[(ind + 1) % 6] + " " + ar[(ind + 2) % 6] + " " + ar[(ind + 3) % 6] + " " + ar[(ind + 4) % 6] + " " + ar[(ind + 5) % 6];
            if (set.contains(x)) {
                System.out.println("Twin snowflakes found.");
                return;
            }
            set.add(x);
            x = (ar[ind2]) + " " + ar[(ind2 - 1 + 6) % 6] + " " + ar[(ind2 - 2 + 6) % 6] + " " + ar[(ind2 - 3 + 6) % 6] + " " + ar[(ind2 - 4 + 6) % 6] + " " + ar[(ind2 - 5 + 6) % 6];
            if (set.contains(x)) {
                System.out.println("Twin snowflakes found.");
                return;
            }
            set.add(x);
        }
            System.out.println("No two snowflakes are alike.");
    }
}