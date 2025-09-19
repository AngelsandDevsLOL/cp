package LCC;

import java.util.Scanner;

public class HalloweenHarvest {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] x = new int[26];
        scanner.nextLine();
        String line = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            x[line.charAt(i)-97]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += x[i]/k;
        }
        System.out.println(count);
    }
}
