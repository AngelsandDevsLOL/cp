package YetAnotherContest;

import java.util.Scanner;

public class Nim {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int ones = 0;
            int not = 0;
            for (int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if (input == 1) ones++;
            }
            if (ones % 2 == 0) System.out.println("Mike");
            else System.out.println("Josh");
        }
    }
}
