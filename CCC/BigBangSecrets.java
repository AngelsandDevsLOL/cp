package CCC;

import java.util.Scanner;

public class BigBangSecrets {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            int shift = (3*(i+1))+k;
            int a = input.charAt(i);
            a = a - shift;
            if (a < 65){
                a = a + 26;
            } else if (a > 90){
                a = a - 26;
            }
            char character = (char) a;
            input = input.substring(0,i) + character + input.substring(i+1,input.length());
        }
        System.out.println(input);
    }
}
