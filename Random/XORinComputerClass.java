package Random;

import java.util.Scanner;

public class XORinComputerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long input, sb, ans = 0;
        long[][] b = new long[30][2];
        for (int i = 0; i < n; i++) {
            input = sc.nextLong();
            for (int j = 0; j < 30; j++) {
                sb = ((input >> j) & 1);
                b[j][0] += (i + 1) * (n - i) * sb;
                b[j][1] += (i + 1) * (n - i) * (sb ^ 1);
            }
        }
        for (int i = 0; i < 30; i++) {
            if (b[i][1] < b[i][0]) {
                ans += (1L << i);
            }
        }
        System.out.println(ans);
    }
}