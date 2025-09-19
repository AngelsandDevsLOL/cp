package COCI;

import java.util.Scanner;

public class Vjeko {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String beginning = input.substring(0, input.indexOf("*"));
        String end = input.substring(input.indexOf("*") + 1);
        for (int i = 0; i < n; i++) {
            String in = sc.nextLine();
            if (in.length() >= beginning.length() + end.length() && in.startsWith(beginning) && in.endsWith(end)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
