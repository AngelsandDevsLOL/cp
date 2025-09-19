package CCC.Senior;

import java.util.*;

public class BridgeTransport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int n = scanner.nextInt();
        int sum = 0;
        int x = 0;
        boolean bool = true;
        int count = 0;
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            ar[i] = input;
            if (i < 4) {
                sum = sum + ar[i];
                if (sum > w) {
                    bool = false;
                    break;
                }
                count++;
            }
        }
        for (int i = 4; i < n && bool; i++) {
            sum = sum - ar[i- 4] + ar[i];
            if (sum > w) {
                bool = false;
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}

