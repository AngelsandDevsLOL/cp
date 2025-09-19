package CCC;

import java.util.Scanner;

public class DaisyChains {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                boolean good = false;
                for (int k = i; k <= j; k++) {
                    if (array[k] * (j - i + 1) == sum) {
                        good = true;
                    }
                }
                if (good) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
