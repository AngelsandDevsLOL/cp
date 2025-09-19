package CCC;

import java.util.Locale;
import java.util.Scanner;

public class EnglishOrFrench {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sCount = 0;
        long tCount = 0;
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String x = scanner.nextLine().toLowerCase(Locale.ROOT);
            for (int j = 0; j < x.length(); j++) {
                if (x.substring(j,j+1).equals("s")){
                    sCount++;
                } else if (x.substring(j,j+1).equals("t")){
                    tCount++;
                }
            }
        }
        if (tCount > sCount){
            System.out.println("English");
        } else
            System.out.println("French");
    }
}
