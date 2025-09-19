
import java.io.*;

public class PromotionCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        FileWriter writer = new FileWriter("promote.out", true); // file writer
        BufferedWriter bw = new BufferedWriter(writer);
        int[] ar = new int[4];
        for (int i = 0; i < 4; i++) {
            String[] input = br.readLine().split(" ");
            ar[i] = Integer.parseInt(input[1]) - Integer.parseInt(input[0]);
        }
        for (int i = 2; i >= 0; i--) {
            ar[i] += ar[i+1];
        }
        for (int i = 1; i < 4; i++) {
            bw.write(ar[i] + "\n");
        }
        bw.flush();
    }
}
