package CCC.MockJ;

import java.util.ArrayList;
import java.util.Scanner;

public class RichardThePenguin {
    public static int k;
    public static ArrayList<String>[] aList;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        int num = (int) (Math.ceil((double)n / k)-1);
        aList = new ArrayList[(int) (n)]; // 0 = 0 glaciers in between, 1 = what glaciers that are only 1 in between??
        for (int i = 0; i < aList.length; i++) {
            aList[i] = new ArrayList<>();
        }
        recursion(n, "", 0, 0);
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            ArrayList<String> aL = aList[i];
            for (int j = 0; j < aL.size(); j++) {
                for (int b = i; b < n - 1; b++) {
                    ArrayList<String> a = aList[b];
                    for (int l = 0; l < a.size(); l++) {
                        //if (a.get(l).contains()) {
                          //  continue;
                       // }
                        cnt++;
                    }
                }
            }
        }
    }
    public static void recursion(int n, String s, int cur, int d) { // generate all kind
        String[] r = s.split(" ");
        for (int i = r.length-1; i > 0; i--) {
            if (Integer.parseInt(r[i]) - Integer.parseInt(r[i-1]) > k) {
                return;
            }
        }
        if (cur >= n) {
            aList[d].add(s);
            return;
        }

        recursion(n, s, cur+1, d);
        recursion(n, s + " " + cur, cur+1, d + 1);
    }
}
