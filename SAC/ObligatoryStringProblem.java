package SAC;

import java.util.Scanner;
import java.util.TreeSet;

public class ObligatoryStringProblem {
    static char[] ar = new char[4];
    static TreeSet<String> tSet = new TreeSet<>();
    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        String input = scanner.nextLine();
        for (int i = 0; i < 4; i++) {
            ar[i] = input.charAt(i);
        }
        int[] newArray = new int[4];
        name(newArray, 0, x);
        for (String string : tSet) {
            System.out.println(string);
        }
    }
    static void name (int[] array, int sum, int x) {
        if (sum <= x) {
            word(array);
        } else {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (array[i] < 12) {
                array[i] = array[i] + 1;
                name (array, sum + 1, x);
                array[i] = array[i] - 1;
            }
        }
    }
    static void word (int[] array) {
        char a = (char) (ar[0] + array[0]);
        char b = (char) (ar[1] + array[1]);
        char c = (char) (ar[2] + array[2]);
        char d = (char) (ar[3] + array[3]);
        char aa = (char) (ar[0] - array[0]);
        char bb = (char) (ar[1] - array[1]);
        char cc = (char) (ar[2] - array[2]);
        char dd = (char) (ar[3] - array[3]);
        if (aa < 97) {
            aa = (char) (aa + 26);
        } if (bb < 97) {
            bb = (char) (bb + 26);
        } if (cc < 97) {
            cc = (char) (cc + 26);
        } if (dd < 97) {
            dd = (char) (dd + 26);
        }
        String string;
        if (a == aa && b == bb && c == cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
        } else if (a == aa && b == bb && c == cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
        } else if (a == aa && b == bb && c != cc && d == d) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
        } else if (a == aa && b != bb && c == cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
        } else if (a != aa && b == bb && c == cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
        } else if (a != aa && b != bb && c == cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
        } else if (a != aa && b == bb && c == cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
        } else if (a != aa && b == bb && c != c && d == d) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
        } else if (a == aa && b != bb && c != cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
        } else if (a == aa && b != bb && c == cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
        } else if (a == aa && b == bb && c != cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
        } else if (a != a && b != bb && c != cc && d == dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
        } else if (a != a && b != bb && c == cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
        } else if (a != a && b == bb && c != cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
        } else if (a == a && b != bb && c != cc && d != dd) {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (dd);
            tSet.add(string);
        }
        else {
            string = (a) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (d);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (c) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(b) + (cc) + (dd);
            tSet.add(string);
            string = (a) + String.valueOf(bb) + (cc) + (dd);
            tSet.add(string);
            string = (aa) + String.valueOf(bb) + (cc) + (dd);
            tSet.add(string);
        }
    }
}
