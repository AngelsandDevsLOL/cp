package USACO;

import java.io.*;
import java.util.*;

public class CowFrisbee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> left = new Stack<Integer>(); // goes from left to right
        Stack<Integer> right = new Stack<Integer>(); // goes from right to left
        int[] input = new int[n];
        long count = 0;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            input[i] = in;
            while (!left.isEmpty() && left.peek() < in) {
                left.pop();
                count += (i - left.pop() + 1);
            }
            left.push(i);
            left.push(in);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!right.isEmpty() && right.peek() < input[i]) {
                right.pop();
                count += (right.pop() - i + 1);
            }
            right.push(i);
            right.push(input[i]);
        }
        System.out.println(count);
    }
}