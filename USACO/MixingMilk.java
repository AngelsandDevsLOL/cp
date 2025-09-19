

import java.util.*;
import java.io.*;

public class MixingMilk {
    public static void main (String[] args) throws IOException{
        File f = new File("mixmilk.out");
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        FileWriter writer = new FileWriter("mixmilk.out", true); // file writer
        BufferedWriter bw = new BufferedWriter(writer);
        int[] cap = new int[3];
        int[] cur = new int[3];
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            int c = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            cap[i] = c;
            cur[i] = m;
        }
        HashMap<String, Integer> hMap = new HashMap<>();
        HashMap<Integer, String> h = new HashMap<>();
        int count = 0;
        int c = 1;
        String s = cur[0] + " " + cur[1] + " " + cur[2];
        do {
            hMap.put(s, count);
            h.put(count, s);
            count++;
            int before = c - 1;
            if (before == -1) before = 2;
            int temp = cur[before];
            cur[before] = Math.max(0,cur[before]-(cap[c]-cur[c]));
            cur[c] = Math.min(cap[c],cur[c] + temp);
            c++;
            if (c == 3) c = 0;
            s = cur[0] + " " + cur[1] + " " + cur[2];
        } while (!hMap.containsKey(s));
        int num = (hMap.get(s));
        int end = count;
        int change = (100-num) % (end - num) + num; // 3
        String[] ar = h.get(change).split(" ");
        for (int i = 0; i < ar.length; i++) {
            bw.write(ar[i] + "\n");
        }
        bw.flush();
    }
}
