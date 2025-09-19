package UCC;

import java.util.Scanner;

public class EmeraldExchange {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int countt = 0;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            if (input % 2 == 0) {
                count = count + input;
            } else {
                if (count > countt) {
                    countt = count;
                }
                count = 0;
            }
        }
        if (count > countt) {
            countt = count;
        }
        System.out.println(countt);
    }
}
