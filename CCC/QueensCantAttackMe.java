package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class QueensCantAttackMe {
    public static void main (String argsp[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        HashSet<String> hSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String input = scanner.nextLine();
            hSet.add(input);
            String[] aString= input.split(" ");
            int x = Integer.parseInt(aString[0]);
            int y = Integer.parseInt(aString[1]);
            for (int j = 1; j <= n; j++) {
                hSet.add(j + " " + y);
                hSet.add(x + " " + j);
            }
            boolean bool = true;
            int tempx = x;
            int tempy = y;
            while (bool) {
                if (tempx-1 <=0 || tempy - 1 <= 0) {
                    break;
                } else {
                    tempx--;
                    tempy--;
                    hSet.add(tempx + " " + tempy);
                }
            }
            tempx = x;
            tempy = y;
            while (bool) {
                if (tempx+1 >n || tempy + 1 > n) {
                    break;
                } else {
                    tempx++;
                    tempy++;
                    hSet.add(tempx + " " + tempy);
                }
            }
            tempx = x;
            tempy = y;
            while (bool) {
                if (tempx+1 > n || tempy - 1 <= 0) {
                    break;
                } else {
                    tempx++;
                    tempy--;
                    hSet.add(tempx + " " + tempy);
                }
            }
            tempx = x;
            tempy = y;
            while (bool) {
                if (tempx-1 <= 0 || tempy + 1 > n) {
                    break;
                } else {
                    tempx--;
                    tempy++;
                    hSet.add(tempx + " " + tempy);
                }
            }
        }
        System.out.println((n*n) - hSet.size());
    }
}
