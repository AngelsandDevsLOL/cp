package WC;

import java.util.Locale;
import java.util.Scanner;

public class Uncrackable {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        boolean bool = true;
        if (!(string.length() <= 12 && string.length() >= 8)){
            bool = false;
        } else if ((!rules(string))){
            bool = false;
        }
        if (bool){
            System.out.println("Valid");
        } else
            System.out.println("Invalid");
    }
    public static boolean rules(String x){
        int lowercase = 0;
        int uppercase = 0;
        int numbers = 0;
        String uppercased = x.toUpperCase(Locale.ROOT);
        for (int i = 0; i < x.length(); i++) {
            if (uppercased.charAt(i) == '0' || uppercased.charAt(i) == '1' || uppercased.charAt(i) == '2' || uppercased.charAt(i) == '3' || uppercased.charAt(i) == '4' || uppercased.charAt(i) == '5' || uppercased.charAt(i) == '6' || uppercased.charAt(i) == '7' || uppercased.charAt(i) == '8' || uppercased.charAt(i) == '9'){
                numbers++;
            } else if (uppercased.charAt(i) == x.charAt(i)){
                uppercase++;
            } else
                lowercase++;
        }
        if (numbers >= 1 && uppercase >= 2 && lowercase >= 3){
            return true;
        } else
            return false;
    }
}
