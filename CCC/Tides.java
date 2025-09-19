package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class Tides {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        scanner.nextLine();
        String[] x = scanner.nextLine().split(" ");
        int[] input = new int[x.length];
        int[] input2 = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            input[i] = Integer.parseInt(x[i]);
            input2[i] = Integer.parseInt(x[i]);
        }
        Arrays.sort(input2);
        int max = input2[input2.length-1];
        int min = input2[0];
        boolean bool = true;
        for (int i = 0; i < input.length-2; i++) {
            int a = input[i];
            int b = input[i+1];
            int c = input[i+2];
            if (b > c && b > a){
                if (max != b){
                    bool = false;
                    break;
                }
            } else if (b < c && b < a){
                if (min != b){
                    bool = false;
                    break;
                }
            }
        }
        if (bool){
            if (max-min == 2){
                System.out.println("unknown");
            } else
            System.out.println(max - min);
        } else
            System.out.println("unknown");
    }
}
