package Random;

import java.util.Scanner;

public class Festival {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] counter = new int[n];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < n; j++) {
                char x = input.charAt(j);
                if (x == 'S') {
                    counter[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (counter[j] + i >= n) {
                    System.out.print("S");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
