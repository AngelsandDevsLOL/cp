package Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class CCCBadHaha {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            int k = sc.nextInt();
            Stack <Integer> s = new Stack<>();
            StringBuilder v = new StringBuilder(String.valueOf(x));
            ArrayList<Integer> aList = new ArrayList<>();
            for (int j = 0; j < v.length() && k > 0; j++) {
                int num = Integer.parseInt(v.substring(j, j + 1));
                while (!s.isEmpty() && s.peek() > num && k > 0) {
                    aList.add(s.pop());
                    k--;
                    v = new StringBuilder(v.substring(0, (j - 1)) + v.substring(j));
                    j--;
                }
                s.add(num);
            }
            Collections.sort(aList);
            while (k > 0 && aList.size() > 0 && !s.isEmpty() && s.peek() > aList.get(0)) {
                aList.add(s.pop());
                v = new StringBuilder(v.substring(0, v.length() - 2));
                k--;
            }
            Collections.sort(aList);
            for (int num : aList) {
                v.append(num);
            }
            System.out.println(v);
        }
    }
}
