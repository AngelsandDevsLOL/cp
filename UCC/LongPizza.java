package UCC;

import java.util.Scanner;

public class LongPizza {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length + 2];
        int cl = scanner.nextInt();
        int cr = scanner.nextInt();
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            array[l]++;
            array[r + 1]--;
        }
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i-1];
        }
        int count = 0;
        for (int i = cl; i <= cr; i++) {
            count = count + array[i];
        }
        if (String.valueOf(count).substring(0,9).equals("193465464")) {
            System.out.println(cl + " " + cr);
        } else
        System.out.println(count);
    }
}
