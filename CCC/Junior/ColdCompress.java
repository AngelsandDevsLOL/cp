package CCC.Junior;

import java.util.Scanner;

public class ColdCompress {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            String input = scanner.nextLine();
            int count = 1;
            String symbol = input.substring(0,1);
            for (int j = 1; j < input.length(); j++) {
                if (symbol.equals(input.substring(j, j + 1))) {
                    count++;
                } else {
                    System.out.print(count + " " + symbol + " ");
                    count = 1;
                    symbol = input.substring(j,j+1);
                }
            }
            System.out.println(count + " " + symbol + " ");
        }
    }
}
