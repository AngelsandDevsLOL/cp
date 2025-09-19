package CCC;

import java.util.Scanner;

public class DNADerren {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String t = "";
        t += line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if ((c == 'A' && line.charAt(i-1) == 'A') || (c != 'A' && line.charAt(i-1) != 'A')) {
                System.out.print(t + " ");
                t = "" + c;
            } else {
                t += c;
            }
        }
        System.out.println(t);
    }
}
