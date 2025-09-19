package COCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Bingo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][][] ar = new int[n][5][5];
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            String name = sc.nextLine();
            names[i] = name;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    ar[i][j][k] = sc.nextInt();
                }
            }
        }
        int m = sc.nextInt();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            hSet.add(sc.nextInt());
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (hSet.contains(ar[i][0][0]) && hSet.contains(ar[i][1][1]) && hSet.contains(ar[i][2][2]) && hSet.contains(ar[i][3][3]) && hSet.contains(ar[i][4][4])) {
                ans.add(names[i]);
                continue;
            }
            if (hSet.contains(ar[i][0][4]) && hSet.contains(ar[i][1][3]) && hSet.contains(ar[i][2][2]) && hSet.contains(ar[i][3][1]) && hSet.contains(ar[i][4][0])) {
                ans.add(names[i]);
                continue;
            }
            for (int j = 0; j < 5; j++) {
                if (hSet.contains(ar[i][j][0]) && hSet.contains(ar[i][j][1]) && hSet.contains(ar[i][j][2]) && hSet.contains(ar[i][j][3]) && hSet.contains(ar[i][j][4])) {
                    ans.add(names[i]);
                    break;
                }
                if (hSet.contains(ar[i][0][j]) && hSet.contains(ar[i][1][j]) && hSet.contains(ar[i][2][j]) && hSet.contains(ar[i][3][j]) && hSet.contains(ar[i][4][j])) {
                    ans.add(names[i]);
                    break;
                }
            }
        }
        System.out.println(ans.size());
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
