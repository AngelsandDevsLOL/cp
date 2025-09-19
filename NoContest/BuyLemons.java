package NoContest;

import java.util.Arrays;
import java.util.Scanner;

public class BuyLemons {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] shops = prime();
        int n = sc.nextInt(), q = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();

        }
    }
    public static int[] prime () {
        int[] prime = new int[5 * 1000000]; // opp
        prime[2] = 1;
        prime[3] = 2;
        prime[4] = 2;
        prime[5] = 3;
        prime[6] = 3;
        prime[7] = 4;
        prime[8] = 4;
        prime[9] = 4;
        prime[10] = 4;
        for (int i = 11; i < Math.sqrt(prime.length) + 1 && prime[i] == 0; i = i + 2) {
            for (int j = i + i; j < prime.length; j++) {
                prime[i]++;
            }
        }
        return prime;
    }
}
