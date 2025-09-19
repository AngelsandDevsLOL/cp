package AlphaStar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyCowAteMyHomework {
    public static void main (String[] ags) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        long currentSum = ar[n - 1];
        double smallest = ar[n - 1];
        int max = ar[n - 1];
        ArrayList<Integer> ans = new ArrayList<>();
        int prevInd = -1;
        long prevSum = ar[n - 1];
        double prevSmal = ar[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (ar[i] > max) max = ar[i];
            if (ar[i] < smallest) smallest = ar[i];
            currentSum += ar[i];
            if ((currentSum - smallest) / (n - i - 1) > (prevSum - prevSmal) / (n - prevInd - 1)) {
                prevSum = currentSum;
                prevSmal = smallest;
                prevInd = i;
                ans.clear();
                ans.add(i);
            } else if ((currentSum - smallest) / (n - i - 1) == (prevSum - prevSmal) / (n - prevInd - 1)) {
                ans.add(i);
            }
        }
        Collections.sort(ans);
        for (int i = 0; i <= ans.size() - 1; i++) {
            System.out.println(ans.get(i));
        }
    }
}
