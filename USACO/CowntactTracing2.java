package USACO;

import java.util.ArrayList;
import java.util.Scanner;

public class CowntactTracing2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String in = sc.nextLine();
        ArrayList<Integer> aList = new ArrayList<>();
        int consec = 0;
        for (int i = 0; i < n; i++) {
            if (in.charAt(i) == '1') {
                consec++;
            } else {
                if (consec != 0) {
                    aList.add(consec);
                    consec = 0;
                }
            }
        }
        int x = 0;
        int y = aList.size();
        if (in.charAt(0) == '1') x++;
        if (in.charAt(n - 1) == '1') y--;
        int minNights = n;
        for (int i = x; i < y; i++) {
            minNights = (int) Math.min(minNights, Math.ceil(aList.get(i) / 2.0));
        }
        if (x == 1) minNights = Math.min(minNights, aList.get(x) - 1);
        if (y == aList.size() - 1) minNights = Math.min(minNights, aList.get(y) - 1);

    }
}
