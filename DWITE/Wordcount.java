package DWITE;

import java.util.Locale;
import java.util.Scanner;

public class Wordcount {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int[] wordCount = new int[5];
        int length = 0;
        for (int i = 0; i < 5; i++) {
            String[] x = (scanner.nextLine().split(" "));
            for (int j = 0; j < x.length; j++) {
                length = x[j].length();
                x[j] = x[j].toLowerCase(Locale.ROOT);
                for (int k = 0; k < x[j].length(); k++) {
                    char character = x[j].charAt(k);
                    if (!(character >= 'a' && character <= 'z')) {
                        length--;
                    } if (character == '\''){
                        length--;
                    }
                }
                if (length > 3){
                    wordCount[i]++;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(wordCount[i]);
        }
    }
}
