package UCC;

import java.util.Scanner;

public class CounterfeitDetection {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int index = 0;
        int count = 0;
        while (index < input.length()) {
            while (index < input.length() && input.substring(index, index + 1).equals("2")) {
                if (index + 1 >= input.length() || !(input.substring(index + 1, index + 2).equals("5"))) {
                    count++;
                }
                index++;
            }
            index++;
        }
        System.out.println(count);
    }
}
