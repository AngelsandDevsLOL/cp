package COCI;

import java.util.HashMap;
import java.util.Scanner;

public class Perket {
    static long smallest = Long.MAX_VALUE;
    static int x;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        int[][] ar = new int[x][2];
        for (int i = 0; i < x; i++) {
            ar[i][0] = scanner.nextInt();
            ar[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < x; i++) {
            recursion(i, ar[i][1], ar[i][0], ar);
        }
        System.out.println(smallest);
    }
    static void recursion (int cur, int bitterness, int sourness, int[][] ingredients) {
        smallest = Math.min(smallest, Math.abs(bitterness - sourness));
        if (cur == x -1) {
            return;
        }
        recursion(cur + 1, bitterness, sourness, ingredients);
        recursion(cur + 1, bitterness + ingredients[cur+1][1], sourness * ingredients[cur+1][0], ingredients);
    }
}







