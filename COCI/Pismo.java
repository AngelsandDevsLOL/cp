package COCI;

import java.util.Scanner;

public class Pismo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int smallest = Integer.MAX_VALUE;
        int prev = sc.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int next = sc.nextInt();
            if (Math.abs(next - prev) < smallest) smallest = Math.abs(next - prev);
            prev = next;
        }
        System.out.println(smallest);
    }
}
