package CCC.Senior;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class BalancedTrees {
    public static HashMap<Integer, Long> ar;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ar = new HashMap<>();
        ar.put(1, 1L);
        System.out.println(recursion(n));
    }
    public static long recursion (int weight) {
        if (ar.containsKey(weight)) return ar.get(weight);
        int x = 1; // weight of each subtree
        int indx = weight; // indx of current subtree
        long count = 0; // count. ..
        while (indx >= 2) {
            int next = weight / (x + 1);
            count += (indx - next) * recursion(x);
            x = weight / next;
            indx = next;
        }
        ar.put(weight, count);
        return count;
    }
}
