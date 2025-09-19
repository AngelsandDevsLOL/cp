package TLE;

import java.util.Scanner;

public class UnluckyNumbers {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] array = new int[1000001];
        for (int i = 0; i < k; i++) {
            int input = scanner.nextInt();
            array[input]++;
        }
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i - 1] + array[i];
        }
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            System.out.println(x - array[x]);
        }
    }
}
