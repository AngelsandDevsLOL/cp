package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class Golf {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int c = scanner.nextInt();
        int sum = 0;
        boolean bool = false;
        int[] array = new int[c];
        for (int i = 0; i < c; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array);
        for (int i = c-1; i >= 0; i--) {
            sum = sum + array[i];
            if (sum >= d){
                System.out.println("Roberta wins in " + (c-i) + " strokes.");
                bool = true;
                break;
            }
        }
        if (bool == false){
            System.out.println("Roberta acknowledges defeat.");
        }
    }
}