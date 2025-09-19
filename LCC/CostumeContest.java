package LCC;

import java.util.Scanner;

public class CostumeContest {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int max = Math.max(b, c);
        if (a >= max) {
            System.out.println(Math.abs(a - max + 1));
        } else {
            System.out.println(0);
        }
    }}
