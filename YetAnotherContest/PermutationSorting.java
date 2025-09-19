package YetAnotherContest;

import java.util.Scanner;

public class PermutationSorting {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur = 0;
        int[] psa = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            if (a == i) {
            } else {
                int min = Math.min(a,i);
                psa[min]++;
                psa[a + i - min + 1]--;
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            psa[i] += psa[i - 1];
            count += psa[i] > 0 ? 1 : 0;
        }
        System.out.println(count);
    }
}
