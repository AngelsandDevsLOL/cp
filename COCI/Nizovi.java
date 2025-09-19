package COCI;

import java.util.Scanner;

public class Nizovi {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int indent = 0;
        String string = "";
        for (int i = 0; i < line.length(); i++) {
            String x = line.substring(i,i+1);
            String output = "";
            if (x.equals("{")) {
                for (int k = 0; k < indent; k++) {
                    output = output + " ";
                }
                System.out.println(output + x);
                indent = indent + 2;
            } else if (x.equals("}")) {
                if (!string.equals("")) {
                    for (int k = 0; k < indent; k++) {
                        output = output + " ";
                    }
                    System.out.println(output + string);
                    string = "";
                }
                string = string + "}";
                indent = indent - 2;
            } else if (x.equals(",")) {
                string = string + ",";
                for (int k = 0; k < indent; k++) {
                    output = output + " ";
                }
                System.out.println(output + string);
                string = "";
            } else {
                string = string + x;
            }
        }
        System.out.println(string);
    }
}
