package CCC.Senior;

import java.util.Scanner;

public class SumGame    {
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] swift = new int[n+1];
        int[] semaphore = new int[n+1];
        for (int i = 1; i <= n; i++) {
            swift[i] = scanner.nextInt()+swift[i-1];
        }
        for (int i = 1; i <= n; i++) {
            semaphore[i] = scanner.nextInt()+semaphore[i-1];
        }
        for (int i = n; i >= 0; i--) {
            if (swift[i] == semaphore[i]) {
                System.out.println(i);
                break;
            }
        }
    }
}
