package Random;

import java.util.Locale;
import java.util.Scanner;

public class BackToSchool_Harambe {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lowercase = 0;
        int uppercase = 0;
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);
            if (x == 'a' || x == 'b' || x == 'c' || x == 'd' || x == 'e' || x == 'f' || x == 'g' || x == 'h' || x == 'i' || x == 'j' || x == 'l' || x == 'k' || x == 'm' || x == 'n' || x == 'o' || x == 'p' || x == 'q' || x == 'r' || x == 's' || x == 't' || x == 'u' || x == 'v' || x == 'w' || x == 'x' || x == 'y' || x == 'z'){
                lowercase++;
            } else if (x == 'A'|| x == 'B' || x == 'C' || x == 'D' || x == 'E' || x == 'F' || x == 'G' || x == 'H' || x == 'I' || x == 'J' || x == 'L' || x == 'K' || x == 'M' || x == 'N' || x == 'O' || x == 'P' || x == 'Q' || x == 'R' || x == 'S' || x == 'T' || x == 'U' || x == 'V' || x == 'W' || x == 'X' || x == 'Y' || x == 'Z'){
                uppercase++;
            }
        }
        if (lowercase > uppercase){
            input = input.toLowerCase(Locale.ROOT);
        } else if (uppercase > lowercase){
            input = input.toUpperCase(Locale.ROOT);
        }
        System.out.println(input);
    }
}
