package AtCOder;

import java.util.HashSet;
import java.util.Scanner;

public class Same {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hSet.add(sc.nextInt());
        }
        if (hSet.size() != 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
