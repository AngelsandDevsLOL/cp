package DMOPC;

import java.util.Scanner;

public class IOI101 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("0")) {
                output = output + "O";
            } else if (input.substring(i,i+1).equals("1")) {
                output = output + "l";
            } else if (input.substring(i,i+1).equals("3")) {
                output = output + "E";
            } else if (input.substring(i,i+1).equals("4")) {
                output = output + "A";
            } else if (input.substring(i,i+1).equals("5")) {
                output = output + "S";
            } else if (input.substring(i,i+1).equals("6")) {
                output = output + "G";
            } else if (input.substring(i,i+1).equals("8")) {
                output = output + "B";
            } else if (input.substring(i,i+1).equals("9")) {
                output = output + "g";
            } else {
                output = output + input.substring(i,i+1);
            }
        }
        System.out.println(output);
    }
}
