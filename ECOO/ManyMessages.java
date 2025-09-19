package ECOO;

import java.util.Scanner;

public class ManyMessages {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int interval = scanner.nextInt();
        int send = scanner.nextInt();
        boolean bool = false;
        for (int i = 0; i < 3; i++) {
            start = start + interval;
            if (send <= start) {
                bool = true;
                System.out.println(start);
                break;
            }
        }
        if (!bool) {
            System.out.println("Who knows...");
        }
    }
}
