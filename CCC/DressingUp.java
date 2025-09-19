package CCC;

import java.util.Scanner;

public class DressingUp {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int x = 1;
        int[] array = new int[h];
        boolean bool = true;
        int k = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = x;
            if (array[i] == h){
                k = i;
            }
            if (array[k] == h){
                x = x-2;
            }else
            x = x + 2;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < (h*2)-(2*array[i]); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
