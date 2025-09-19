package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class DoYouKnowYourABCs {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[7];
        for (int i = 0; i < 7; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        int a = array[0];
        int b = array[1];
        int c = array[6]-array[0]-array[1];
        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
    }
}
