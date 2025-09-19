package CCC;

import java.util.Arrays;
import java.util.Scanner;

public class EvenMoreOddPhotos {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int even = 0;
        int odd = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] % 2 == 0){
                even++;
            } else
                odd++;
        }
        if (odd > even){
            int dif = odd - even;
            dif = (int) Math.floor(dif/2);
            
        } else
            System.out.println(odd+2);
        // even + even = even
        // odd + odd = even
        // even + odd = odd
        // odd + odd + odd = odd
        Arrays.sort(array);

    }
}
