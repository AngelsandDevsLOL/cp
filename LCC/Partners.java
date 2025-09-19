package LCC;

import java.util.Scanner;

public class Partners {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = sc.nextInt();
        long sum = first;
        for (int i = 1; i < 2 * n; i++) {
            sum += sc.nextInt();
        }
        System.out.println(sum / n - first);
    }
}
