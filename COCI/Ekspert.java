package COCI;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ekspert {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong(), y = sc.nextLong();
        long target = x * y;
        int count = 0;
        long[] ar = new long[4];
        ar[0] = x;
        ar[1] = y;
        ar[3] = 1;
        StringBuilder sb = new StringBuilder();
        if (x > y) {
            long num = target / ar[0];
            count += num;
            ar[2] += ar[0] * num;
            for (int i = 0; i < num; i++) {
                sb.append("A C C\n");
            }
            num = (target - ar[2]) / ar[1];
            count += num;
            ar[2] += ar[1] * num;
            for (int i = 0; i < num; i++) {
                sb.append("B C C\n");
            }
            num = target - ar[2];
            count += num;
            for (int i = 0; i < num; i++) {
                sb.append("D C C\n");
            }
        } else {
            long num = target / ar[1];
            count += num;
            ar[2] += ar[1] * num;
            for (int i = 0; i < num; i++) {
                sb.append("B C C\n");
            }
            num = (target - ar[2]) / ar[0];
            count += num;
            ar[2] += ar[0] * num;
            for (int i = 0; i < num; i++) {
                sb.append("A C C\n");
            }
            num = target - ar[2];
            count += num;
            for (int i = 0; i < num; i++) {
                sb.append("D C C\n");
            }
        }
        System.out.println(count);
        System.out.print(sb.toString());
        System.out.println("C");
    }
}
