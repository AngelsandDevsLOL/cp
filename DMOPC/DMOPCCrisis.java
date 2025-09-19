package DMOPC;

import java.util.Scanner;

public class DMOPCCrisis {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (x <= n) {
            if (x<= n) {
                sb.append("_");
            }
            if (x + 1 <= n) {
                sb.append("_");
            }
            if (x + 2 <= n) {
                sb.append("M");
                count++;
            }
            if (x + 3 <= n) {
                sb.append("M");
                count++;
            }
            x = x + 4;
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
