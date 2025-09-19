package Random;

import java.util.Scanner;

public class GoingToSchool {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        long time = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt(), r = sc.nextInt(), g = sc.nextInt();
            time += p - x;
            x = p;
            long num = time % (r + g);
            if (num < r) { // wait
                time += (r - num);
            }
        }
        time += (d - x);
        System.out.println(time);
    }
}
