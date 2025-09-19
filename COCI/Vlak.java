package COCI;

import java.util.*;

public class Vlak {
    public static int count;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ar = new String[n];
        int count = 0;
        int[] cha = new int[20000];
        ArrayList<Integer>[] aList = new ArrayList[20000];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            ar[i] = input;
        }
        for (int i = 0; i < 20000; i++) {
            aList[i] = new ArrayList<>();
        }
        int m = sc.nextInt();
        sc.nextLine();
        String[] ar2 = new String[m];
        for (int i = 0; i < m; i++) {
            String input = sc.nextLine();
            ar2[i] = input;
        }
        Arrays.sort(ar); Arrays.sort(ar2);
        boolean ans = recursion(cha, aList, ar, ar2, 0, n, 0, m, 0, 0);
        if (ans) System.out.println("Nina");
        else System.out.println("Emilija");
    }
    public static boolean recursion (int[] cha, ArrayList<Integer>[] aList, String[] ar, String[] ar2, int l, int r, int l1, int r1, int index, int prev) {
        TreeMap<Integer, Integer> tSet = new TreeMap<>();
        for (int i = l; i < r; i++) {
            if (ar[i].length() == index) {l++; continue;}
            int num = ar[i].charAt(index) - 'a';
            if (tSet.containsKey(num)) tSet.put(num, tSet.get(num) + 1);
            else tSet.put(num, 1);
        }
        if (tSet.isEmpty()) return index % 2 == 1;
        int counter = 0;
        for (int temp : tSet.keySet()) {
            count++;
            cha[count] = temp;
            aList[prev].add(count);

            int j;
            for (j = l1; j < r1; j++) {
                if (ar2[j].length() == index) continue;
                if (ar2[j].charAt(index) - 'a' == temp) break;
            }
            if (j == r1) {
                if (index % 2 == 0) return true;
                return false;
            }
            int i;
            for (i = j + 1; i < r1; i++) {
                if (ar2[i].length() == index) {
                    continue;
                }
                if (ar2[i].charAt(index) - 'a' != temp) break;
            }

            boolean ans = recursion(cha, aList, ar2, ar, j, i, l + counter, l + counter + tSet.get(temp), index + 1, count);
            if (ans && index % 2 == 0) return true;
            else if (!ans && index % 2 == 1) return false;

            counter += tSet.get(temp);
        }
        return index % 2 == 1;
    }
}
