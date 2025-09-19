package CCC;

import java.util.Scanner;

public class Mispelling {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] array = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            String[] temp = string.split(" ");
            int integer = Integer.parseInt(temp[0]);
            String size = String.valueOf(integer);
            int integeragain = size.length();
            String stringg = string.substring(integeragain+1);
            String part1 = stringg.substring(0,integer-1);
            String part2 = stringg.substring(integer,stringg.length());
            stringg = part1+part2;
            array[i] = stringg;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1) +" "+ array[i]);
        }
    }
}
