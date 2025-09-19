package CCC;

import java.util.Locale;
import java.util.Scanner;

public class Poetry2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        String[] array = new String[x];
        scanner.nextLine();
        for (int i = 0; i < x; i++) {
            String[] array2 = new String[4];
            for (int j = 0; j < 4; j++) {
                String[] input = scanner.nextLine().split(" ");
                String lastWord = input[input.length - 1].toLowerCase(Locale.ROOT);

                array2[j] = String.valueOf(lastWord.charAt(lastWord.length()-1));
                for (int k = lastWord.length(); k > 0; k--) {
                    char letter = lastWord.charAt(k-1);
                    if (letter == 'a' || letter == 'o' || letter == 'i' || letter == 'e' || letter == 'u') {
                        array2[j] = lastWord.substring(k);
                        break;
                    }
                }
            }
            if (array2[0].equals(array2[1]) && array2[0].equals(array2[2]) && array2[0].equals(array2[3])) {
                array[i] = "perfect";
            } else if (array2[1].equals(array2[3]) && array2[0].equals(array2[2])) {
                array[i] = "cross";
            } else if (array2[1].equals(array2[2]) && array2[0].equals(array2[3])) {
                array[i] = "shell";
            } else if (array2[0].equals(array2[1]) && array2[2].equals(array2[3])) {
                array[i] = "even";
            } else
                array[i] = "free";
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}