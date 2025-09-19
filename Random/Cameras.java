package Random;

import java.util.Scanner;

public class Cameras {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int r = scanner.nextInt();
        boolean[] array = new boolean[n];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            int input = scanner.nextInt();
            array[input] = true;
        }
        for (int i = 0; i < r; i++) {
            if (array[i]) {
                sum++;
            }
        }
        int count = 0;
        if (sum < 2) {
            if (!array[r - 1]) {
                array[r - 1] = true;
                sum++;
                count++;
            }
            if (sum < 2) {
                if (!array[r - 1]) {
                    array[r - 1] = true;
                    sum++;
                    count++;
                }
            }
        }
        for (int i = 1; i < n - r; i++) {
            if (array[i]) {
                sum--;
            }
            if (array[i + r]) {
                sum++;
            }
            if (sum < 2) {
                if (!array[i + r - 1]) {
                    array[i + r - 1] = true;
                    sum++;
                    count++;
                }
                if (sum < 2) {
                    if (!array[i + r - 1]) {
                        array[i + r - 1] = true;
                        sum++;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        /*
        int trail = 0;
        int lead = n;
        int count = 0;
        int sum = k;
        while (true) {
            for (int i = lead - 1; sum < 2; i--) // add cameras for this gap
                if (!array[i]) {
                    array[i] = true;
                    count++;
                }
            if (lead >= n) // done?
                break;
            if (array[trail++]) // advance pointers
                sum--;
            if (array[lead++])
                sum++;
        }
        System.out.println(count);
         */
    }
}
