package CCC;

import java.util.Scanner;

public class SumacSequences {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t1 = scanner.nextInt();
        int t2 = scanner.nextInt();
        int count = 2;
        int next = t1 - t2;
        while (next >= 0) {
            count++;
            int temp = next;
            next = t2 - next;
            t2 = temp;
        }
        System.out.println(count);
    }
}
