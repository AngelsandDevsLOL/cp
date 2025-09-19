package CCC;

import java.util.Scanner;

public class SenselessCensus {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int m = scanner.nextInt();
        int countT = 0;
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                if (input.substring(j,j+1).equals("t")){
                    countT++;
                }
            }
        }
        System.out.println(countT);
    }
}