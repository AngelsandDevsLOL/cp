package USACO;

import java.util.Scanner;

public class MilkExchange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        int start = -1;
        for (int i = 0; i < n - 1; i++) {
            if (input.charAt(i + 1) == 'R') {
                if (input.charAt(i) == 'L') {
                    start = i + 1;
                    break;
                } else {
                    i++;
                }
            }
        }
        long count = 0;
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            count += ar[i];
        }
        if (start == -1) {
            if (input.charAt(input.length()-1) == 'L' && input.charAt(0) == 'R') {
                start = 0;
            } else {
                System.out.println(count);
                return;
            }
        }
        int i = start;
        do {
            long left = 0;
            for (; ; i++) {
                if (i < n - 1 && input.charAt(i + 1) == 'R') left += ar[i];
                else if (i == n - 1 && input.charAt(0) == 'R') {left += ar[i]; i = -1;}
                else break;
            }
            count -= Math.min(left, m);
            i += 2;
            if (i == n) i = 0;
            else if (i == n + 1) i = 1;
            left = 0;
            for (; ; i++) {
                if (i < n - 1 && input.charAt(i) == 'L') left += ar[i];
                else if (i == n - 1 && input.charAt(n - 1) == 'L') {left += ar[i]; i = -1;}
                else break;
            }
            count -= Math.min(left, m);
        } while (i < n && i != start);
        System.out.println(count);
    }
}
