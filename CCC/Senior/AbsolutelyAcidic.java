package CCC.Senior;

import java.util.HashSet;
import java.util.Scanner;

public class AbsolutelyAcidic {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] freq = new int[1001];
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            freq[input]++;
        }
        int largest = 0;
        int secondLargest = 0;
        int lsmall = 1001;
        int llarge = 0;
        int ssmall = 1001;
        int slarge = 0;
        boolean lbool = false;
        boolean sbool = false;
        for (int i = 1; i < 1001; i++) {
            if (freq[i] > largest) {
                secondLargest = largest;
                largest = freq[i];
            } else if (freq[i] > secondLargest) {
                secondLargest = freq[i];
            } else if (freq[i] == largest) {
                secondLargest = freq[i];
            }
        }
        for (int i = 1; i < 1001; i++) {
            if (freq[i] == largest) {
                if (i > llarge) llarge = i;
                if (i < lsmall) lsmall = i;
            } if (freq[i] == secondLargest) {
                if (i > slarge) slarge = i;
                if (i < ssmall) ssmall = i;
            }
        }
        System.out.println(Math.max(Math.abs(llarge - ssmall), Math.abs(slarge - lsmall)));
    }
}
