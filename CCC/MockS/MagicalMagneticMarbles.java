package CCC.MockS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MagicalMagneticMarbles {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        String in = sc.nextLine();
        int prevMarble = -1;
        ArrayList<Integer> dis = new ArrayList<>();
        boolean marble = false;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (in.charAt(i) == '0') {
                if (marble) {
                    count++;
                    if (prevMarble != -1) {
                        dis.add(i - prevMarble - 1);
                    }
                    prevMarble = i;
                    marble = false;
                }
            } else {
                marble = true;
            }
        }
        if (marble) {
            count++;
            if (prevMarble != -1) {
                dis.add(n - prevMarble - 1);
            }
        }
        Collections.sort(dis);
        int[] ar = new int[dis.size()];
        if (dis.size() >= 1) ar[0] = dis.get(0);
        for (int i = 1; i < dis.size(); i++) {
            ar[i] += ar[i - 1] + dis.get(i);
        }
        if (count == 0 && k == 0) System.out.println(0);
        else System.out.println(Math.max(count - bSearch(ar, k), 1));
    }
    public static int bSearch (int[] dis, int find) {
        int low = 0;
        int high = dis.length - 1;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (dis[mid] <= find) {
                low = mid + 1;
                ans = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
