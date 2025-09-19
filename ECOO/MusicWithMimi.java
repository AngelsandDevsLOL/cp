package ECOO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MusicWithMimi {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in); // 12 notes
        String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};
        int q = sc.nextInt();
        HashMap<String, String> hSet = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            String a = notes[i];
            String b = notes[i + 4];
            String c = notes[i + 7];
            String d = notes[i + 10];
            String help = a + " " + b + " " + c + " " + d;
            if (hSet.containsKey(help)) {
                break;
            }
            hSet.put(a + " " + b + " " + c + " " + d, "root");
            String temp = a;
            a = b;
            b = c;
            c = d;
            d = temp;
            hSet.put(a + " " + b + " " + c + " " + d, "first");
            temp = a;
            a = b;
            b = c;
            c = d;
            d = temp;
            hSet.put(a + " " + b + " " + c + " " + d, "second");
            temp = a;
            a = b;
            b = c;
            c = d;
            d = temp;
            hSet.put(a + " " + b + " " + c + " " + d, "third");
        }
        sc.nextLine();
        for (int i = 0; i < q; i++) {
            String input = sc.nextLine();
            if (hSet.containsKey(input)) {
                System.out.println(hSet.get(input));
            } else {
                System.out.println("invalid");
            }
        }
    }
}
