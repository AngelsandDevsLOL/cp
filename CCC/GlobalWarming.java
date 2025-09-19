package CCC;

import java.util.Scanner;

public class GlobalWarming {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while (x != 0) {
            int[] array = new int[x];
            int[] dif = new int[x-1];
            for (int i = 0; i < x; i++) {
                array[i] = scanner.nextInt();
            }
            for (int i = 1; i < x; i++) {
                dif[i-1] = (array[i]-array[i-1]);
            }
            if (dif.length != 0) {
                System.out.println(pattern(dif));
            } else
                System.out.println(0);
            x = scanner.nextInt();
        }
    }
    static int pattern (int dif[]){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < dif.length; i++) {
            if (!(dif[i] > 0)){
                string.append(dif[i] + " ");
            } else
                string.append("+"+dif[i] + " ");
        }
        String sb = String.valueOf(string);
        String string2 = "";
        if (dif[0]>=0){
            string2 = "+";
        }
        boolean bool = true;
        string2 = string2+String.valueOf(dif[0]) + " ";
        int index = sb.indexOf(string2,1);
        if (!(index == -1)) {
            String repeatingPart = sb.substring(0, index);
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i = i + repeatingPart.length()) {
                stringbuilder.append(repeatingPart);
            }
            String stringg = stringbuilder.toString();
            if (!(String.valueOf(string).equals(stringg.substring(0, string.length())))) {
                bool = false;
            }
            int positive = 0;
            int negative = 0;
            int space = 0;
            if (bool) {
                String[] array = repeatingPart.split(" ");
                return array.length;
            }
        }
        return dif.length;
    }
}
