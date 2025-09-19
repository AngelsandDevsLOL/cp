package USACO;

import java.io.*;
import java.util.*;

public class OutOfPlace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        FileWriter writer = new FileWriter("outofplace.out", true); // file writer
        BufferedWriter bw = new BufferedWriter(writer);
        int x = Integer.parseInt(br.readLine());
        int[] ar = new int[x];
        int num = Integer.parseInt(br.readLine());
        ar[0] = num;
        for (int i = 1; i < x; i++) {
            ar[i] = Integer.parseInt(br.readLine());
            if (ar[i] < ar[i-1]) {
                num = i - 1; // 10 1 2 num = 0 (10) 2 3 6 1 8, num = 2 (6)
            }
        }
        boolean bool = true;
        if (num == 0 || !(ar[num - 1] < ar[num + 1])) { // 6 7 1 8 not 1 10 2 3
            num++;
            bool = false;
        }
        int index = binarySearch(0, x-1, num, ar, bool);
        int count;
        if (num > index) {
            count = Math.abs(num - index - 1);
            for (int i = num - 2; i >= index; i--) {
                if (ar[i] == ar[i + 1]) {
                    count--;
                }
            }
        } else {
            count = Math.abs(num - index);
            for (int i = index - 1; i >= num; i--) {
                if (ar[i] == ar[i + 1]) {
                    count--;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.flush();
        bw.close();

    }
    public static int binarySearch(int low, int high, int find, int[] array, boolean bool) { // returns index right before slot
        int ans = 0;
        int temp = find;
        find = array[find];
        array[temp] = -1;
        while (low <= high) {
            int mid = (low + high) / 2; // put between mid, mid + 1
            if (find < array[mid]) high = mid - 1;
            if (!bool && array[mid] == find) {
                ans = mid;
                low = mid + 1;
            } else if (bool && array[mid] == find){
                high = mid - 1;
            }
            if (find > array[mid]) {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
