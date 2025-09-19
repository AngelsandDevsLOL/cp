package CCC;

import java.util.Scanner;

public class SecretInstructions2 {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String direction = "";
        while (!input.equals("99999")) {
            int digit1 = Integer.parseInt(input.substring(0,1));
            int digit2 = Integer.parseInt(input.substring(1,2));
            if (digit1 + digit2 == 0) {
                System.out.println(direction + input.substring(2));
            } else if ((digit1+digit2) % 2 == 0) {
                System.out.println("right " + input.substring(2));
                direction = "right ";
            } else if ((digit2 + digit1) % 2 != 0) {
                System.out.println("left " + input.substring(2));
                direction = "left ";
            }
            input = scanner.nextLine();
        }
    }
}
