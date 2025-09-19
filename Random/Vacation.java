package Random;

import java.util.Scanner;

public class Vacation {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[3];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int x = a + Math.max(ar[1], ar[2]);
            int y = b + Math.max(ar[0], ar[2]);
            int z = c + Math.max(ar[0], ar[1]);
            ar[0] = x; ar[1] = y; ar[2] = z;
        }
        System.out.println(Math.max(Math.max(ar[0],ar[1]), ar[2]));
    }
}
