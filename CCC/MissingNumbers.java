package CCC;

import java.util.Scanner;

public class MissingNumbers {
    public static void main (String args[]){
        Scanner in = new Scanner(System.in);
        for (int t = in.nextInt(); t> 0; t--) {
            long n = in.nextLong();
            long s = in.nextLong();
            long dif = n*(n+1)/2-s;
            long minY = dif/2 + 1;
            long maxY = Math.min(dif-1, n);
            System.out.println(maxY-minY+1);
        }
    }
}
