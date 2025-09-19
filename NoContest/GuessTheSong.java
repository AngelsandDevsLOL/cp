package NoContest;

import java.util.Scanner;

public class GuessTheSong {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            String in = scanner.nextLine();
            if (in.startsWith(input[1])) {
                count++;
            }
        }
        System.out.println(count);
    }
}
