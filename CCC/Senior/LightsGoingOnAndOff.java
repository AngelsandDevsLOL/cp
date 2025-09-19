package CCC.Senior;

import java.util.HashSet;
import java.util.Scanner;

public class LightsGoingOnAndOff {
    static HashSet<Integer> hSet = new HashSet<>();
    static int[] ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), l = sc.nextInt();
        ar = new int[r];
        for (int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < l; j++) {
                int x = sc.nextInt();
                sb.append(x);
            }
            ar[i] = Integer.parseInt((sb.toString()), 2);
        }
        int xor = ar[r - 1];
        for (int i = r - 2; i >= 0; i--) {
            hSet.add(xor);
            xor = xor ^ ar[i];
        }
        hSet.add(xor);
        System.out.println(hSet.size());
    }
}
