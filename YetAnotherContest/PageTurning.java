package YetAnotherContest;

import java.util.ArrayList;
import java.util.Scanner;

public class PageTurning {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        long count = 0;
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
            if (ar[i] % 2 == 0) even.add(ar[i]);
            else {
                odd.add(ar[i]);
                count += (ar[i] - 1) / 2;
            }
        }

        if (odd.isEmpty()) {
            for (int i = 0; i < even.size(); i++) {
                count += even.get(i) / 2;
            }
            System.out.println(count);
            for (int i = 0; i < n; i++) {
                System.out.print(i + 1 + " ");
            }
        } else {
            for (int i : even) {
                count += i / 2 - 1;
            }
            System.out.println(count);
            int oddCount = 1;
            int evenCount = 2;
            for (int i = 0; i < n; i++) {
                if (ar[i] % 2 == 0) {
                    System.out.print(evenCount++ + " ");
                } else {
                    System.out.print(oddCount + " ");
                    if (oddCount == 1) {
                        oddCount = even.size() + 2;
                    } else {
                        oddCount++;
                    }
                }
            }
        }
        System.out.println();
    }
}
