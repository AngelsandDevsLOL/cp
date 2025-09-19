
import java.util.HashSet;
import java.util.Scanner;

public class DistinctNumbers {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<Integer> hSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hSet.add(sc.nextInt());
        }
        System.out.println(hSet.size());
    }
}
