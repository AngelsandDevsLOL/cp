package USACO;

import java.util.Scanner;

public class MooOperations {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String input = sc.nextLine();
            if (input.length() < 3) System.out.println(-1);
            else if (input.contains("MOO")) { // MOOM
                System.out.println(input.length() - 3);
            } else if (input.contains("MOM") || input.contains("OOO")) { // MMOMM
                System.out.println(input.length() - 2);
            } else if (input.contains("OO")) { //OOMM
                System.out.println(input.length() - 1);
            } else {
                System.out.println(-1);
            }
        }
    }
}