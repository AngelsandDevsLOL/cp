package LCC;

import java.util.Scanner;

public class CookieMonster {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'c' || input.charAt(i) == 'o' || input.charAt(i) == 'k' || input.charAt(i) == 'i' || input.charAt(i) == 'e') {
                count++;
            }
        }
        System.out.println(count);
    }
}
