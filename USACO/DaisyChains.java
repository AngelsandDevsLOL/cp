package USACO;

import java.util.HashSet;
import java.util.Scanner;

public class DaisyChains {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] ar = new int[x];
        for (int i = 0; i < x; i++) {
            ar[i] = scanner.nextInt();
        }
        int count = x;
        for (int i = 0; i < x; i++) {
            int sum = ar[i];
            HashSet<Integer> hSet = new HashSet<>();
            hSet.add(ar[i]);
            for (int j = i+1; j < x; j++) {
                hSet.add(ar[j]);
                sum = sum + ar[j];
                if (sum % (j-i+1) == 0 && hSet.contains(sum / (j-i + 1))) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
