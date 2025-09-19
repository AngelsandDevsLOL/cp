package NoContest;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueElements {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hSet.add(scanner.nextInt());
        }
        System.out.println(hSet.size());
    }
}
