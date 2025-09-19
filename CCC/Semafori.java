package CCC;

import java.util.Scanner;

public class Semafori {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int time = 0;
        int distance = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            time = time + d-distance;
            int mod = time%(r+g);
            if (mod < r){
                int x = r-mod;
                time = time + x;
                l = l + x;
            }

            distance = d;
        }
        System.out.println(total + l);
    }
}
