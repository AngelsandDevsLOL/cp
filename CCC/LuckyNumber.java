package CCC;

import java.util.Scanner;

public class LuckyNumber {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[x];
        for (int i = 0; i < x; i++) {
            array[i] = scanner.nextLine();
        }
        int[] finalResults = new int[x];
        for (int i = 0; i < x; i++) {
            finalResults[i] = addition(array[i]);
        }
        for (int i = 0; i < x; i++) {
            System.out.println(finalResults[i]);
        }
    }
    static int addition (String y){

        while (y.length() != 1) {
          long    zero = 0;
            for (int i = 0; i < y.length(); i++) {
                zero = zero + Integer.parseInt(y.substring(i, i + 1));
            }
            y = String.valueOf(zero);
        }
        return  Integer.parseInt(y);
    }
}
