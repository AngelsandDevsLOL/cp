package ECOO;

import java.util.HashSet;
import java.util.Scanner;

public class Boggled {
    static boolean boool = false;
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int p = 0; p < 5; p++) {
            String input1 = scanner.nextLine();
            String input2 = scanner.nextLine();
            String input3 = scanner.nextLine();
            String input4 = scanner.nextLine();
            String[][] array = new String[4][input1.length()];
            for (int i = 0; i < input4.length(); i++) {
                array[0][i] = input1.substring(i, i + 1);
            }
            for (int i = 0; i < input4.length(); i++) {
                array[1][i] = input2.substring(i, i + 1);
            }
            for (int i = 0; i < input4.length(); i++) {
                array[2][i] = input3.substring(i, i + 1);
            }
            for (int i = 0; i < input4.length(); i++) {
                array[3][i] = input4.substring(i, i + 1);
            }
            String n = scanner.nextLine();
            boolean bool = false;
            HashSet<String> words = new HashSet<>();
            int repeated = 0;
            int score = 0;
            int notFound = 0;
            int tooShort = 0;
            for (int j = 0; j < Integer.parseInt(n); j++) {
                boool = false;
                String input = scanner.nextLine();
                if (input.length() < 3) {
                    tooShort++;
                    continue;
                }
                if (words.contains(input)) {
                    repeated++;
                    continue;
                }
                bool = false;
                int index1 = input1.indexOf(input.substring(0,1));
                int index2 = input2.indexOf(input.substring(0,1));
                int index3 = input3.indexOf(input.substring(0,1));
                int index4 = input4.indexOf(input.substring(0,1));
                while (!boool && index1 != -1 && !bool) {
                    boolean[][] used = new boolean[4][input1.length()];
                    used[0][index1] = true;
                    if (recursion(bool, input, 1, used, 0, index1, array, input1.length())) {
                        bool = true;
                    }
                    used[0][index1] = false;
                    index1 = input1.indexOf(input.substring(0,1), index1 + 1);
                }
                while (!boool && index2 != -1 && !bool) {
                    boolean[][] used = new boolean[4][input1.length()];
                    used[1][index2] = true;
                    if (recursion(bool, input, 1, used, 1, index2, array, input1.length())) {
                        bool = true;
                    }                    used[0][index2] = true;
                    index2 = input2.indexOf(input.substring(0,1), index2 + 1);
                }
                while (!boool && index3 != -1 && !bool) {
                    boolean[][] used = new boolean[4][input1.length()];
                    used[2][index3] = true;
                    if (recursion(bool, input, 1, used, 2, index3, array, input1.length())) {
                        bool = true;
                    }                    used[0][index3] = true;
                    index3 = input3.indexOf(input.substring(0,1), index3 + 1);
                }
                while (!boool && index4 != -1 && !bool) {
                    boolean[][] used = new boolean[4][input1.length()];
                    used[3][index4] = true;
                    if (recursion(bool, input, 1, used, 3, index4, array, input1.length())) {
                        bool = true;
                    }                    used[0][index4] = true;
                    index4 = input4.indexOf(input.substring(0,1), index4 + 1);
                }
                if (boool) {
                    if (input.length() == 3 || input.length() == 4) {
                        score++;
                    } else if (input.length() == 5) {
                        score = score + 2;
                    } else if (input.length() == 6) {
                        score = score + 3;
                    } else if (input.length() == 7) {
                        score = score + 4;
                    } else {
                        score = score + 11;
                    }
                } else {
                    notFound++;
                }
                words.add(input);
            }
            System.out.println("Your score: " + score + " (" + (Integer.parseInt(n) - notFound - tooShort - repeated) + " good, " + notFound + " not found, " + tooShort + " too short, " + repeated + " repeated)");
        }
    } static boolean recursion (boolean bool, String input, int number, boolean[][] used, int x, int y, String[][] array, int length) {
        if (number == input.length()) {
            bool = true;
            boool = true;
            return bool;
        }
        String character = input.substring(number, number + 1);
        if (x != 0 && y != 0) { // left, up
            if (!used[x - 1][y - 1]) {
                if (array[x - 1][y - 1].equals(character)) {
                    used[x - 1][y - 1] = true;
                    recursion(bool, input, number + 1, used, x - 1, y - 1, array, length);
                    used[x - 1][y - 1] = false;
                }
            }
        } if (x != 0 && y != length-1) { // up right
            if (!used[x - 1][y + 1]) {
                if (array[x - 1][y + 1].equals(character)) {
                    used[x - 1][y + 1] = true;
                    recursion(bool, input, number + 1, used, x - 1, y + 1, array, length);
                    used[x - 1][y + 1] = false;
                }
            }
        } if (!boool && x != 0) { // up
            if (!used[x-1][y]) {
                if (array[x-1][y].equals(character)) {
                    used[x-1][y] = true;
                    recursion(bool, input, number + 1, used, x - 1, y, array, length);
                    used[x-1][y] = false;
                }
            }
        } if (!boool && y != 0) { // left
            if (!used[x][y-1]) {
                if (array[x][y-1].equals(character)) {
                    used[x][y-1] = true;
                    recursion(bool, input, number + 1, used, x, y - 1, array, length);
                    used[x][y-1] = false;
                }
            }
        } if (!boool && x != 3 && y != length-1) { // down right
            if (!used[x + 1][y + 1]) {
                if (array[x + 1][y + 1].equals(character)) {
                    used[x + 1][y + 1] = true;
                    recursion(bool, input, number + 1, used, x + 1, y + 1, array, length);
                    used[x + 1][y + 1] = false;
                }
            }
        } if (!boool && x != 3 && y != 0) { // down left
            if (!used[x + 1][y - 1]) {
                if (array[x + 1][y - 1].equals(character)) {
                    used[x + 1][y - 1] = true;
                    recursion(bool, input, number + 1, used, x + 1, y - 1, array, length);
                    used[x + 1][y - 1] = false;
                }
            }
        } if (!boool && x != 3) { // down
            if (!used[x+1][y]) {
                if (array[x+1][y].equals(character)) {
                    used[x+1][y] = true;
                    recursion(bool, input, number + 1, used, x + 1, y, array, length);
                    used[x+1][y] = false;
                }
            }
        } if (!boool && y != length - 1) { // right
            if (!used[x][y+1]) {
                if (array[x][y+1].equals(character)) {
                    used[x][y+1] = true;
                    recursion(bool, input, number + 1, used, x, y + 1, array, length);
                    used[x][y+1] = false;
                }
            }
        }
        return false;
    }
}