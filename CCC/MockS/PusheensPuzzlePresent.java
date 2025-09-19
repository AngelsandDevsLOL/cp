package CCC.MockS;

import java.util.Scanner;

public class PusheensPuzzlePresent {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int firstx = -1;
        int lastx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sc.nextInt() != i * n + j + 1) {
                    lastx = i;
                    if (firstx == -1) firstx = i;
                }
            }
        }
        System.out.println(lastx - firstx + 1);
    }
}
