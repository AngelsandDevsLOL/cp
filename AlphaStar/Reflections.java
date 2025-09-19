package AlphaStar;

import java.util.Scanner;

public class Reflections {
    public static int r, c;
    public static int[][] ar;
    public static boolean[][][] vis;
    public static int[] temp = new int[3]; // row/column, up/down/left/right, index from top
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt(); c = sc.nextInt();
        ar = new int[r][c];
        sc.nextLine();
        vis = new boolean[2][4][Math.max(r, c)];
        for (int i = 0; i < r; i++) {
            String input = sc.nextLine();
            for (int j = 0; j < c; j++) {
                if (input.charAt(j) == '\\') ar[i][j] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            ans = Math.max(ans, path(i, 0, 1));
            ans = Math.max(ans, path(i, c-1, 3));
        }
        for (int i = 0; i < c; i++) {
            ans = Math.max(ans, path(0, i, 0));
            ans = Math.max(ans, path(r-1, i, 2));
        }
        System.out.println(ans);
    }
    public static int path (int x, int y, int direction){
        int count = 0;
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int[] bounce1 = new int[]{3, 2, 1, 0};
        int[] bounce2 = new int[]{1, 0, 3, 2};
        while (x >= 0 && y >= 0 && x < r && y < c) {
            count++;
            if (ar[x][y] == 0) direction = bounce1[direction];
            else direction = bounce2[direction];
            x += dr[direction];
            y += dc[direction];
        }
        return count;
    }
}
