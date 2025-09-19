package AlphaStar;

import java.util.Scanner;

public class LightWitch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        short[] ar = new short[20];
        for (int i = 0; i < 20; i++) {
            ar[i] = sc.nextShort();
        }
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << 21); i++) {
            int sum = 0;
            if ((ar[19] + (((i | 1) == i) ? 1 : 0) + (((i | 2) == i) ? 1 : 0)) % 2 != 0) continue;
            if ((ar[0] + (((i | (1 << 19)) == i) ? 1 : 0) + (((i | (1 << 18)) == i) ? 1 : 0)) % 2 != 0) continue;
            boolean works = true;
            for (int j = 1; j < 19; j++) {
                if ((ar[j] + (((i | (1 << (19 - j))) == i) ? 1 : 0) + (((i | (1 << (20 - j))) == i) ? 1 : 0) + (((i | (1 << (18 - j))) == i) ? 1 : 0)) % 2 != 0) {
                    works = false;
                    break;
                }
            }
            if (!works) continue;
            for (int j = 0; j < 21; j++) {
                if ((i | (1 << j)) == i) sum++;
            }
            smallest = Math.min(smallest, sum);
        }
        System.out.println(smallest);
    }
}
