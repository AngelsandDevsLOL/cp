package Arcadia;

import java.util.Scanner;

public class Chemistry {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        if (x >= 2 && y >= 2) {
            System.out.println(4);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(((i % 2 == 0) ? 1 : 3) + ((j % 2 == 0) ? 0 : 1) + " ");
                }
                System.out.println();
            }
        } else if (x == 1 && y == 1){
            System.out.println(1);
            System.out.println(1);
        } else { // 1 and another number
            System.out.println(2);
            int count = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    System.out.print(((count % 2 == 0) ? 1 : 2) + " ");
                    count++;
                }
                System.out.println();
            }
        }
    }
}
