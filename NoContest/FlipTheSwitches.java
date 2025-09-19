package NoContest;

import java.util.Scanner;

public class FlipTheSwitches {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int count = 0;
        String string = scanner.nextLine();
        String input = string.substring(0,1);
        for (int i = 1; i < n; i++) {
            if (!input.substring(input.length()-1).equals(string.substring(i,i+1))) {
                input = input + string.substring(i,i+1);
            }
        }
        while (input.contains("1")) {
            count++;
            int last = input.lastIndexOf("1");
            input = input.substring(0, last);
            if (input.contains("0")) {
                count++;
            }
        }
        System.out.println(count);
    }
}
