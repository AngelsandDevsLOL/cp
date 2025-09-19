package CCC;

import java.util.Scanner;

public class SimpleEncryption {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
        String message1 = scanner.nextLine();
        String message = "";
        for (int i = 0; i < message1.length(); i++) {
            for (char j = 'A'; j < 'Z'; j++) {
                if (message1.charAt(i) == j) {
                    message = message + message1.charAt(i);
                }
            }
        }
        String output = "";
        String[][] stringA = new String[(int) Math.ceil(message.length() / keyword.length())+1][keyword.length()];
        int x = 0;
        for (int i = 0; i < (int) Math.ceil(message.length() / keyword.length())+1; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (message.length() > x) {
                    stringA[i][j] = String.valueOf(message.charAt(x));
                } else
                    break;
                x++;
            }
        }
        for (int i = 0; i < keyword.length(); i++) {
            char character = keyword.charAt(i);
            for (int j = 0; j < (int) Math.ceil(message.length() / keyword.length())+1; j++) {
                if (stringA[j][i] == null){
                    break;
                }
                char characterr = (char) (stringA[j][i].charAt(0) + character - 65);
                if (characterr > 90){
                    int number = characterr;
                    characterr = (char)(number - 26);
                }
                stringA[j][i] = String.valueOf(characterr);
            }
        }
        x = 0;
        for (int i = 0; i < (int) Math.ceil(message.length() / keyword.length())+1; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (message.length() > x) {
                    System.out.print(stringA[i][j]);
                } else
                    break;
                x++;
            }
        }
    }
}