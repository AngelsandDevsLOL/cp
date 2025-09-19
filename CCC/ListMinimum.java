package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class ListMinimum {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = 0; i < x; i++) {
            System.out.println(array[i]);
        }
    }
}
