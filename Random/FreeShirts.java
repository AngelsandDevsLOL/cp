package Random;

import java.util.Arrays;
import java.util.Scanner;

public class FreeShirts {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            int count = 0;
            int day = 1;
            int shirt = 1;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int d = scanner.nextInt();
            int[] eventDays = new int[m];
            for (int j = 0; j < m; j++) {
                eventDays[j] = scanner.nextInt();
            }
            Arrays.sort(eventDays);
            for (int j = 0; j < m; j++) {
                int nextEvent = eventDays[j];
                count = count + ((nextEvent - day)/n);
                int remainder = (nextEvent-day) % n;
                shirt = shirt + remainder;
                while (shirt > n) {
                    count++;
                    shirt = shirt - n;
                }
                day = nextEvent;
                n++;
            }
            if (day != d) {
                int nextEvent = d;
                count = count + ((nextEvent - day) / n);
                int remainder = (nextEvent - day) % n;
                shirt = shirt + remainder;
                while (shirt > n) {
                    count++;
                    shirt = shirt - n;
                }
            }
            System.out.println(count);
        }
    }
}
