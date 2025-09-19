package CCC.Senior;

import java.util.Scanner;

public class Spirals2 {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[][] array = new int[105][105];
        int xx = 51;
        int yy = 51;
        String direction = "down";
        array[yy][xx] = x;
        x++;
        int smaly = xx;
        int bigy = xx;
        int smalx = yy;
        int bigx = yy;
        while (x != y + 1) {
            if (direction.equals("down")) {
                yy++;
                if (array[yy][xx+1] == 0) {
                    direction = "right";
                }
            } else if (direction.equals("right")){
                xx++;
                if (array[yy-1][xx] == 0) {
                    direction = "up";
                }
            } else if (direction.equals("up")) {
                yy--;
                if (array[yy][xx-1] == 0) {
                    direction = "left";
                }
            } else if (direction.equals("left")) {
                xx--;
                if (array[yy+1][xx] == 0) {
                    direction = "down";
                }
            }
            if (yy > bigy) {
                bigy = yy;
            } else if (yy < smaly){
                smaly = yy;
            }
            if (xx > bigx) {
                bigx = xx;
            } else if (xx < smalx){
                smalx = xx;
            }
            array[yy][xx] = x;
            x++;
        }
        for (int i = smaly; i <= bigy; i++) {
            String string = "";
            for (int j = smalx; j <= bigx; j++) {
                if (array[i][j] == 0) {
                    string = string + " ";
                } else {
                    string = string + array[i][j] + " ";
                }
            }
            System.out.println(string);
        }
    }
}
