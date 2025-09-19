package CCC;

import java.util.Scanner;

public class DoTheShuffle {
    public static void main (String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        String[] playlist = {"A", "B", "C", "D", "E"};
        while (n != 4){
            if (n == 1){
                for (int i = 0; i < x; i++) {
                    move1(playlist);
                }
            } else if (n == 2){
                for (int i = 0; i < x; i++) {
                    move2(playlist);
                }
            } else if (n == 3){
                for (int i = 0; i < x; i++) {
                    swap(playlist);
                }
            }
            n = scanner.nextInt();
            x = scanner.nextInt();
        }
        scanner.nextLine();
        for (int i = 0; i < 5; i++) {
            System.out.print(playlist[i] + " ");
        }
    }
    static void move1 (String playlist[]){
        String[] playlist2 = new String[5];
        for (int i = 0; i < 4; i++) {
            playlist2[i] = playlist[i+1];
        }
        playlist2[4] = playlist[0];
        for (int i = 0; i < 5; i++) {
            playlist[i] = playlist2[i];
        }
    }
    static void move2 (String playlist[]){
        String[] playlist2 = new String[5];
        for (int i = 0; i < 4; i++) {
            playlist2[i+1] = playlist[i];
        }
        playlist2[0] = playlist[4];
        for (int i = 0; i < 5; i++) {
            playlist[i] = playlist2[i];
        }
    }
    static void swap (String playlist[]){
        String secondSong = (playlist[1]);
        playlist[1] = playlist[0];
        playlist[0] = secondSong;
    }
}
