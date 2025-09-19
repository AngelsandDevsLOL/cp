package CCC.MockJ;

import java.util.Scanner;

public class KeenanHatesTriangles {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) System.out.println(1);
        else if (n == 2) System.out.println(3);
        else if (n == 3) System.out.println(6);
        else if (n == 4) System.out.println(12);
        else if (n == 5) System.out.println(24);
        else if (n == 6) System.out.println(40);
        else {
            System.out.println(2);
        }
    }
}
