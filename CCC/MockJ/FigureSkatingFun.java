package CCC.MockJ;

import java.util.Scanner;

public class FigureSkatingFun {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            sum = sum + array[i];
        }
        boolean bool = true;
        if (sum % 2 != 0) {
            bool = false;
        }
        sum = sum / 2;
        int tempSum = 0;
        int count = 0;
        for (int integer : array) {
            tempSum = tempSum + integer;
            count++;
            if (tempSum > sum) {
                bool = false;
                break;
            } else if (tempSum == sum) {
                break;
            }
        }
        if (bool) {
            System.out.println(count);
        } else {
            System.out.println("Andrew is sad.");
        }
    }
}
