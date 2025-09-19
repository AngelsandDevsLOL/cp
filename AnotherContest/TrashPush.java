package AnotherContest;

import java.util.Scanner;

public class TrashPush {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            double n = scanner.nextInt();
            double k = scanner.nextInt();
            int string = (int) (Math.ceil(n/k));
            if (string > n){
                string = (int) n;
            }
            System.out.println(string);
        }
    }
}
