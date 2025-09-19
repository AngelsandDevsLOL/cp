package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class BoxandWhiskers {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        System.out.print(array[0]);
        System.out.print(" " + array[n - 1]);
        String y = String.valueOf(median(array, n, 0, (n / 2)-1));
        int index = y.indexOf(".");
        if (y.substring(index).equals(".0")) {
            System.out.print(" " + y.substring(0, index));
        } else
            System.out.print(" " + y);
        String x = String.valueOf(median(array, n, 0, n-1));

        index = x.indexOf(".");
        if (x.substring(index).equals(".0")) {
            System.out.print(" " + x.substring(0, index));
        } else
            System.out.print(" " + x);
        double n2 = n;
        double number = Math.ceil(n2/2);
        String z = String.valueOf(median(array, n, (int) number, n-1));
        if (z.substring(index).equals(".0")) {
            System.out.print(" " + z.substring(0, index));
        } else
            System.out.print(" " + z);
    }

    static double median(int[] array, int size, int a, int b) {
        double x = (b + a);
        x = x / 2;
        int aa = array[(int) Math.floor(x)];
        int bb = array[(int) Math.ceil(x)];
        double aaa = aa + bb;
        double ab = aaa / 2;
        return ab;
    }
}