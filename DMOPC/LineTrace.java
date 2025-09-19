package DMOPC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class LineTrace {
    public static int count = 0;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        int[] arr = new int[n];
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
            arr[i] = i+1;
            hSet.add(ar[i]);
        }
        if (hSet.size() < n) {
            System.out.println(-1);
        } else {
            boolean bool = true;
            for (int i = 0; i < arr.length; i++) {
                if (!hSet.contains(arr[i])) {
                    bool = false;
                    System.out.println(-1);
                    break;
                }
            }
            if (bool) {
                while (!Arrays.equals(ar, arr)) {
                    bubble(ar);
                }
                System.out.println(count);
            }
        }
    }
    public static void bubble (int[] ar){
        for (int i = 0; i < ar.length-1; i++) {
            int a = ar[i];
            int b = ar[i+1];
            if (a > b) {
                ar[i] = ar[i+1];
                ar[i+1] = a;
                count++;
            }
        }
    }
}
