package AnimalContest;

import java.util.Scanner;

public class WorkoutRoutine {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int num = k;
        double number = ((n+1) * n) / 2;
        double number2 = ((n-1) * n) / 2;
        number = Math.ceil(number/k);
        for (int i = 1; i < n; i++) {
            System.out.print(i + " ");
        }
        int output = (int) (number * k - number2);

        System.out.println(output);
    }
}
