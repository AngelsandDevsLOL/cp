package Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RunningInCircles2 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            int n = scanner.nextInt();
            if (i != 1 && i != 3) {
                for (int j = 0; j < n * 2; j++) {
                    int x = scanner.nextInt();
                    break;
                }
            } else {
                System.out.println(n);
                for (int j = 0; j < n; j++) {
                    int a = scanner.nextInt();
                    int b = scanner.nextInt();
                    System.out.println(a);
                    System.out.println(b);
                }
                System.out.println();
            }
        }
    }
}
