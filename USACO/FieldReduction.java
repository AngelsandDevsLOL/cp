package USACO;
 // bad.
import java.io.*;

public class FieldReduction {
    public static void main(String[] args) throws IOException {
        File f = new File("reduce.out");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("reduce.out", true); // file writer
        BufferedWriter bw = new BufferedWriter(writer);
        int n = Integer.parseInt(br.readLine());
        bw.newLine();
        int largestx = 0;
        int secondlargestx = 0;
        int largesty = 0;
        int secondlargesty = 0;
        int smallestx = 40000;
        int secondsmallestx = 40000;
        int smallesty = 40000;
        int secondsmallesty = 40000;
        for (int i = 0; i < n; i++) {
            String[] coords = br.readLine().split(" ");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            if (x >= largestx) {
                secondlargestx = largestx;
                largestx = x;
            } else if (x > secondlargestx) {
                secondlargestx = x;
            }
            if (y >= largesty) {
                secondlargesty = largesty;
                largesty = y;
            } else if (y > secondlargesty) {
                secondlargesty = y;
            }
            if (x <= smallestx) {
                secondsmallestx = smallestx;
                smallestx = x;
            } else if (x < secondsmallestx) {
                secondsmallestx = x;
            }
            if (y <= smallesty) {
                secondsmallesty = smallesty;
                smallesty = y;
            } else if (y < secondsmallesty) {
                secondsmallesty = y;
            }
        }
        secondsmallesty--; smallesty--; largesty--; secondlargesty--;
        secondsmallestx--; smallestx--; largestx--; secondlargestx--;
        int area = (largestx - smallestx) * (largesty - smallesty);
        int temparea = area;
        temparea = Math.min(temparea, (secondlargestx - smallestx) * (largesty - smallesty));
        temparea = Math.min(temparea, (largestx - smallestx) * (secondlargesty - smallesty));
        temparea = Math.min(temparea, (largestx - secondsmallestx) * (largesty - smallesty));
        temparea = Math.min(temparea, (largestx - smallestx) * (largesty - secondsmallesty));
        System.out.println(temparea);
        bw.newLine();
        bw.flush();
    }
}
