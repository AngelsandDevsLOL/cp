package CCC.Senior;

import java.util.Scanner;

public class GoodFoursGoodFives {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int max = n / 5;
        for (int i = 0; i < max + 1; i++) {
            int x = i * 5;
            x = n - x;
            if (x % 4 == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
