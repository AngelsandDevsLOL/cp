package USACO;

import java.util.Scanner;
import java.util.TreeSet;

public class BalancingInversions {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer>[] firstHalf = new TreeSet[2];
        firstHalf[0] = new TreeSet<>(); firstHalf[1] = new TreeSet<>();
        TreeSet<Integer>[] secondHalf = new TreeSet[2];
        secondHalf[0] = new TreeSet<>(); secondHalf[1] = new TreeSet<>();
        int one1 = 0;
        int one2 = 0; // # of 1's in the second half
        int inversion1 = 0;
        int inversion2 = 0;
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            firstHalf[input].add(i);
            if (input == 1) one1++;
            else {
                inversion1 += one1;
            }
        }
        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            secondHalf[input].add(i);
            if (input == 1) one2++;
            else {
                inversion2 += one2;
            }
        }
        int ans = 0;
        while (inversion1 != inversion2) {
            if (inversion1 > inversion2) {
                if (firstHalf[1].size() > secondHalf[0].size() && !secondHalf[1].isEmpty() && !firstHalf[0].isEmpty()) { // decrease both
                    int leftSwaps = n - firstHalf[0].floor(n - 1) - 1;
                    int rightSwaps = secondHalf[1].ceiling(0);
                    if (leftSwaps + rightSwaps + 1 < (firstHalf[1].size() - secondHalf[0].size())) {

                    }
                } else if (firstHalf[1].size() < secondHalf[0].size()) {

                }
            }
        }
    }
}
