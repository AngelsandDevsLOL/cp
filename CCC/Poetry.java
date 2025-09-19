package CCC;


import java.util.Locale;
import java.util.Scanner;

public class Poetry {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.nextLine();
        String[] lyrics = new String[number*4];
        for (int x = 0; x < (number * 4); x++) {

            lyrics[x] = scanner.nextLine().toLowerCase(Locale.ROOT);
        }
        for (int k=0;k<number;k++) {
            String[] rythm = new String[4];
            for (int x = 0; x < 4; x++) {
                String[] sentence = lyrics[k*4+x].split(" ");
                String lastWord = sentence[sentence.length - 1];
                rythm[x] = lastWord;
                for (int i = 0;  i< lastWord.length(); i++) {
                    char letter = lastWord.charAt(i);

                    if (letter == 'a' || letter == 'o' || letter == 'i' || letter == 'e' || letter == 'u') {

                        rythm[x] = lastWord.substring(i);
                    }
                }


            }
            String result="free";
            if ((rythm[0].equals(rythm[1])) && (rythm[1].equals(rythm[2])) && (rythm[2].equals(rythm[3]))){
                result = "perfect";
            }
            else if ((rythm[0].equals(rythm[1])) && (rythm[2].equals(rythm[3]))){
                result = "even";
            }
            else if ((rythm[0].equals(rythm[2]))&& (rythm[1].equals(rythm[3])))
                result = "cross";
            else if ((rythm[0].equals(rythm[3]))&& (rythm[2].equals(rythm[1])))
                result = "shell";
            System.out.println(result);
        }

    }
}