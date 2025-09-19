package LCC;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MinMaxing {
    public static void method (int x) throws IOException {
        PrintWriter in = new PrintWriter(new FileWriter(x + ".in"));
        PrintWriter out = new PrintWriter(new FileWriter(x + ".out"));

        int m = (int)(Math.random() * 100000) + 1;
        int n = (int)(Math.random() * (1000000 / m) + 1) * m;

        in.println(n + " " + m);

        long sum = 0;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = (int)(Math.random() * 1000000) + 1;
            sum += input[i];
            in.print(input[i] + " ");
        }
        in.println();

        Arrays.sort(input);
        long ans1 = sum;
        long ans2 = sum;
        for (int i = 0; i < n / m; i++) { // loop through the # of groups = total number of people / number of people per group
            ans1 -= input[i]; // decrease by the (n / m)-th smallest values
            ans2 -= input[i * m]; // decrease by the smallest per group
        }
        out.println(ans1);
        out.println(ans2);
        out.close();
        in.close();
    }
    public static void main (String[] args) throws IOException {
        for (int i = 21; i <= 40; i++) {
            method(i);
        }
    }
}
