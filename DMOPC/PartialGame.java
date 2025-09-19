package DMOPC;

import java.util.Scanner;

public class PartialGame {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long duke = 0;
        long alice = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input % 2 == 0) {
                duke += input / 2;
            } else {
                alice += Math.ceil(input / 2.0);
            }
        }
        if (duke > alice) System.out.println("Duke");
        else System.out.println("Alice");
    }
}
