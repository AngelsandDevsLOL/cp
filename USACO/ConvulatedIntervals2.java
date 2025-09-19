package USACO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConvulatedIntervals2 {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer initial = new StringTokenizer(read.readLine());
        int intervalNum = Integer.parseInt(initial.nextToken());
        int maxMag = Integer.parseInt(initial.nextToken());
        int[] startNum = new int[maxMag + 1];
        int[] endNum = new int[maxMag + 1];
        for (int i = 0; i < intervalNum; i++) {
            int[] interval = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (interval[0] > interval[1]) {
                throw new IllegalArgumentException("invalid interval i hate you");
            }
            startNum[interval[0]]++;
            endNum[interval[1]]++;
        }
        long[] coveredNum = new long[2 * maxMag + 2];
        for (int i = 0; i <= maxMag; i++) {
            for (int j = 0; j <= maxMag; j++) {
                coveredNum[i + j] += (long) startNum[i] * startNum[j];
                coveredNum[i + j + 1] -= (long) endNum[i] * endNum[j];
            }
        }
        // get the actual array from the initial stuff we constructed
        long currAmt = 0;
        for (int i = 0; i <= 2 * maxMag; i++) { // prefix sum arr
            currAmt += coveredNum[i];
            coveredNum[i] = currAmt;
        }
        for (int i = 0; i <= 2 * maxMag; i++) {
            System.out.println(coveredNum[i]);
        }
    }
}