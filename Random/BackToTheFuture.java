package Random;

import java.util.Scanner;

public class BackToTheFuture {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            // turn to binary, flip, turn back
            String bin = Integer.toBinaryString(x);
            StringBuilder sb = new StringBuilder();
            sb.append(bin);
            sb.reverse();
            System.out.println(Integer.parseInt(sb.toString(),2));
        }
    }
}
