package AlphaStar;

import java.util.*;

public class MixedUpNames {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[][] ar = new String[n][2];
        TreeMap<String, Integer> sorted1 = new TreeMap<>();
        TreeMap<String, Integer> sorted2 = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            char[] input = sc.nextLine().toCharArray();
            Arrays.sort(input);
            ar[i][0] = input.toString();
            sorted1.put(ar[i][0], i);
          //  Arrays.sort(input, Collections.reverse);
            sorted2.put(ar[i][1], i);
        }
    }
}
