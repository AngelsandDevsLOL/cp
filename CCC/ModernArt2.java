package CCC;

import java.util.Scanner;

public class ModernArt2 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] row = new int[m];
        int[] col = new int[n];
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("R")) {
                row[Integer.parseInt(input[1])-1]++;
            } else {
                col[Integer.parseInt(input[1])-1]++;
            }
        }
        int gold = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[j] + col[i]) % 2 != 0) {
                    gold++;
                }
            }
        }
        System.out.println(gold);
    }
}
