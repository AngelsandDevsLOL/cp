package CCC.Senior;

import java.util.Scanner;

public class AromaticNumbers {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] sym = new int[input.length()/2];
        int[] num = new int[input.length()/2];
        for (int i = 0; i < input.length(); i=i+2) {
            String s = input.substring(i+1,i+2);
            int symbol = 0;
            if (s.equals("I")) {
                symbol = 1;
            } else if (s.equals("V")) {
                symbol = 5;
            } else if (s.equals("X")) {
                symbol = 10;
            } else if (s.equals("L")) {
                symbol = 50;
            } else if (s.equals("C")) symbol = 100;
            else if (s.equals("D")) symbol = 500;
            else if (s.equals("M")) symbol = 1000;
            sym[i/2] = symbol;
            num[i/2] = Integer.parseInt(input.substring(i,i+1));
        }
        int sum = 0;
        for (int i = 1; i < input.length()/2; i++) {
            if (sym[i] > sym[i-1]) {
                sum -= num[i-1] * sym[i-1];
            } else {
                sum += num[i-1] *sym[i-1];
            }
        }
        sum += num[input.length()/2-1] * sym[input.length()/2-1];
        System.out.println(sum);
    }
}
