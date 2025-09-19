package CCC;

import java.util.Scanner;

public class PumpkinPatches {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        scanner.nextLine();
        int maxy = 0;
        int miny = 1000000;
        int maxx = 0;
        int minx = 1000000;
        for (int i = 0; i < p; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (y > maxy){
                maxy = y;
            } else if (y < miny){
                miny = y;
            } if (x > maxx){
                maxx = x;
            } else if (x < minx){
                minx = x;
            }
        }
        System.out.println(2*((maxy-miny)+(maxx-minx)));
    }
}
