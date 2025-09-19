package CCC.MockS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RichardThePenguin {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[4]);
            int a = Integer.parseInt(input[2]);
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[3]);
            System.out.print((n - k) * a + (k - 1) * c);
            System.out.print(" ");
            System.out.println((n - k) * b + (k - 1) * c);
        }
    }
}
