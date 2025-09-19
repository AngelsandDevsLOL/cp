package CCC;

import java.util.HashSet;
import java.util.Scanner;

public class BobsContestScore {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        HashSet<Integer> hset = new HashSet();
        hset.add(0);
        int sum = 0;
        for (int i = 0; i < n; i++) {
                sum = sum + array[i];
                hset.add(sum);
                for (int j = i + 1; j < n; j++) {
                    sum = sum + array[j];
                    hset.add(sum);
                    for (int k = j + 1; k < n; k++) {
                        sum = sum + array[k];
                        hset.add(sum);
                        for (int a = k + 1; a < n; a++) {
                            sum = sum + array[a];
                            hset.add(sum);
                        }
                    }
                }
                sum = 0;
            }
        System.out.println(hset.size());
    }
}
