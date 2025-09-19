package NoContest;

import java.util.Scanner;

public class LemonGame {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int count = 0;
            while (n != 0 && m != 0) {
                if (n > m) {
                    int num = n / m;
                    n = n - (num * m);
                } else if (m > n) {
                    int num = m / n;
                    m = m - (num * n);
                }
                if (n == 0 || m == 0) {
                    if (count % 2 == 0) {
                        System.out.println("Alice Win");
                    } else {
                        System.out.println("Bob Win");
                    }
                    break;
                }
                count++;
            }
        }
    }
}