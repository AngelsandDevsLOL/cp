package CCC;

import java.util.Scanner;

public class BoilingWater {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        int integer = 5*b-400;
        System.out.println(integer);
        if (integer < 100){
            System.out.println(1);
        } else if (integer == 100){
            System.out.println(0);
        } else
            System.out.println(-1);
    }
}
