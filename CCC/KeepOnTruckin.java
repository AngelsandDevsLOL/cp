package CCC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class KeepOnTruckin {
    public static long[] psa;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), n = sc.nextInt();
        TreeMap<Integer, Integer> tMap = new TreeMap();
        int[] ar = new int[14 + n];
        long[] motels = new long[14 + n];
        motels[0] = 1;
        ar[0] = 0; ar[1] = 990; ar[2] = 1010; ar[3] = 1970; ar[4] = 2030; ar[5] = 2940; ar[6] = 3060; ar[7] = 3930; ar[8] = 4060; ar[9] = 4970; ar[10] = 5030; ar[11] = 5990; ar[12] = 6010; ar[13] = 7000;
        for (int i = 0; i < n; i++) {
            ar[i + 14] = sc.nextInt();
        }
        Arrays.sort(ar);
        for (int i = 0; i < ar.length; i++) {
            tMap.put(ar[i], i);
        }
        for (int i = 0; i < 14 + n; i++) {
            if (motels[i] == 0) continue;
            if (tMap.ceilingKey(a + ar[i])== null || tMap.floorKey(b + ar[i]) == null) continue;
            int value1 = tMap.get(tMap.ceilingKey(a + ar[i]));
            int value2 = tMap.get(tMap.floorKey(b + ar[i]));
            for (int j = value1; j <= value2; j++) {
                motels[j] += motels[i];
            }
        }
        System.out.println(motels[13 + n]);
    }
}
