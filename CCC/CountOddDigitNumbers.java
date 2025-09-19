package CCC;

import java.util.Scanner;

public class CountOddDigitNumbers {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        String input = String.valueOf(n);
        long count = 0;
        long num = 0;
        long numb = 0;
        long number = 0;
        for (int i = 1; i <= input.length(); i = i + 2) { // i = digits
            if (i == input.length()){
                number = (long) Math.pow(10, i-1);
                count = (long) (count + n - number + 1);
            } else {
                num = (long) Math.pow(10, i);
                numb = (long) Math.pow(10, i - 1);
                count = count + num - numb;
            }
        }
        System.out.println(count);
    }
}
