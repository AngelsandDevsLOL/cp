package CCC;

import java.util.Scanner;

public class SecretInstructions {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        String direction = "";
        System.out.println();
        while (!(x.equals("99999"))){
            int digit1 = Integer.parseInt(x.substring(0,1));
            int digit2 = Integer.parseInt(x.substring(1,2));
            int sum = digit1+digit2;
            if (sum % 2 == 1){
                direction = "left";
            } else if (sum % 2 == 0 && sum != 0){
                direction = "right";
            }
            System.out.println(direction + " " + x.substring(2,5));
            x = scanner.nextLine();
        }
    }
}
