package SAC;

import java.util.Scanner;

public class BadmintonScoring {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long count = 0;
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int o = scanner.nextInt();
            if (m > o) {
                count++;
            }
        }
        System.out.println(count);
    }
}
