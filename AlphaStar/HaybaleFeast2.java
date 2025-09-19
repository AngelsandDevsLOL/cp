package AlphaStar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner; // not working :( practice 2-pointer

public class HaybaleFeast2 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); long m = sc.nextLong();
        Queue<Integer> spic = new LinkedList<>();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            int flavor = sc.nextInt(), spiciness = sc.nextInt();
            input[i][0] = flavor; input[i][1] = spiciness;
        }
        int ans = Integer.MAX_VALUE;
        long sum = input[0][0];
        int right = 0;
        spic.add(input[0][1]);
        for (int i = 0; i < n; i++) {
            while (sum < m && right != n - 1) {
                right++;
                sum += input[right][0];
                while (!spic.isEmpty() && spic.peek() < input[right][1]) {
                    spic.poll();
                }
                spic.add(input[right][1]);
            }
            if (sum < m) break;
            ans = Math.min(ans, spic.peek());
            sum -= input[i][0];
            if (spic.peek() == input[i][1]) spic.poll();
        }
        System.out.println(ans);
    }
}
