package CCC;

import java.io.IOException;
import java.util.Scanner;

public class ModernArt {
    public static void main (String args[]) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] row = new int[m+1];
        int[] col = new int[n+1];
        for (int i = 1; i <= k; i++) {
            char op = scanner.next().charAt(0);
            int x = scanner.nextInt();
            if (op == 'R'){
                row[x]++;
            } else
                col[x]++;
        }
        int evenr = 0;
        int oddr = 0;
        int evenc = 0;
        int oddc = 0;
        for (int i = 1; i <= m; i++) {
            if (row[i] % 2 == 0){
                evenr++;
            } else
                oddr++;
        }
        for (int i = 1; i <= n; i++) {
            if (col[i] % 2 == 0){
                evenc++;
            } else
                oddc++;
        }
        System.out.println(evenr*oddc + oddr * evenc);
    }
}
