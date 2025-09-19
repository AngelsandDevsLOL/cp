package CCC;

import java.util.HashMap;
import java.util.Scanner;

public class FeedingFriendsy {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int time = 0;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (c == 1){
                for (int j = a; j <= b; j++) {
                    hMap.put(j,3);
                }
            } else if (c == 0){
                for (int j = a; j <= b; j++) {
                    if (!hMap.containsKey(j)){
                        hMap.put(j,1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (c == 1){
                for (int j = a; j <= b; j++) {
                    hMap.put(j,3);
                }
            } else if (c == 0){
                for (int j = a; j <= b; j++) {
                    if (!hMap.containsKey(j)){
                        hMap.put(j,1);
                    }
                }
            }
        }
        int points = 0;
        while (time < T){
            if (hMap.containsKey(time)){
                points = points + hMap.get(time);
            }
            time++;
        }
        System.out.println(points);
    }
}