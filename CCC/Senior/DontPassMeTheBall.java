package CCC.Senior;

import java.util.Scanner;

public class DontPassMeTheBall {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int j = scanner.nextInt() - 3;
        int sum = 0;
        for (int i = 1; i <= j; i++) {
            sum = sum + i * (j - i + 1);
        }
        System.out.println(sum);
    }
}
