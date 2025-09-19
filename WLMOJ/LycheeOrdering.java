package WLMOJ;

import java.util.Scanner;
import java.util.TreeMap;

public class LycheeOrdering {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        TreeMap<Integer, String> tMap = new TreeMap<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            tMap.put(-1 * Integer.parseInt(input[1]), input[0]);
        }
        String[] ar = new String[n + 1];
        int count = 1;
        for (int i : tMap.keySet()) {
            ar[count++] = tMap.get(i);
        }
        for (int i = 0; i < q; i++) {
            int ranking = sc.nextInt();
            System.out.println(ar[ranking]);
        }
    }
}
