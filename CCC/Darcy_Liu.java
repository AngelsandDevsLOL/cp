package CCC;

import java.util.Locale;
import java.util.Scanner;

public class Darcy_Liu {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(Locale.ROOT);
        String string = input.substring(0,5);
        String string2 = input.substring(input.length()-3);
        if (input.equals("darcy_liu")) {
            System.out.println("real");
        } else if (input.substring(0,5).equals("darcy") && input.substring(input.length()-3).equals("liu")) {
            String anotherstring = input.substring(5, input.length()-4);
            boolean bool = true;
            for (int i = 0; i < anotherstring.length(); i++) {
                if (!(anotherstring.substring(i,i+1).equals("_"))) {
                    bool = false;
                }
            }
            String x = input.substring(0,6);
            String y = input.substring(input.length()-4);
            if (x.equals("darcy_") && y.equals("_liu") && bool) {
                System.out.println("fake");
            } else
                System.out.println("other user");
        } else
            System.out.println("other user");
    }
}
