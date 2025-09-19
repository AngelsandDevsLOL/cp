package YetAnotherContest;

import java.util.Scanner;

public class NoMoreSeparation {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n && count < m; j++) {
                System.out.println(i + " " + j);
                count++;
            }
        }
    }
}
