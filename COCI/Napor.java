package COCI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Napor {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> aList = new ArrayList<>();
        int length = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) >= 'a' && input.charAt(j) <= 'z') {
                    if (!sb.toString().equals("")) {
                        length = Math.max(sb.toString().length(), length);
                        aList.add(sb.toString());
                        sb.delete(0, sb.toString().length());
                    }
                } else if (input.charAt(j) != '0' && (sb.toString().equals("") || !sb.toString().startsWith("0"))) {
                    sb.append(input.charAt(j));
                } else if (input.charAt(j) != '0') {
                    sb.delete(0, sb.toString().length());
                    sb.append(input.charAt(j));
                } else {
                    if (sb.toString().equals("") || !sb.toString().startsWith("0")) {
                        sb.append("0");
                    }
                }
            }
            if (!sb.toString().equals("")) {
                aList.add(sb.toString());
                length = Math.max(length, sb.toString().length());
            }
        }
        ArrayList<String> newAr = new ArrayList<>();
        StringBuilder spaces = new StringBuilder();
        spaces.append("00");
        for (int i = 0; i < 6; i++) {
            spaces.append(spaces.toString());
        }
        for (String str : aList) {
            newAr.add(spaces.toString().substring(0,length - str.length()) + str);
        }
        Collections.sort(newAr);
        for (String str : newAr) {
            int index = -1;
            for (int i = 0; i < str.length() - 1; i++) {
                if (str.charAt(i) == '0') {
                    index = i;
                } else break;
            }
            System.out.println(str.substring(index + 1));
        }
    }
}
