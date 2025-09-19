package COCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Studentsko {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        int[] skills = new int[n];
        for (int i = 0; i < n; i++) {
            skills[i] = sc.nextInt();
        }
        int[] input = Arrays.copyOf(skills, n);
        Arrays.sort(skills);
        for (int i = 0; i < skills.length; i++) {
            hMap.put(skills[i],i);
        }
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(0);
        int size = 0;
        for (int i = 0; i < n; i++) {
            skills[i] = (int) Math.ceil((hMap.get(input[i]) + 1) * 1.0 / k);
            int index = binarySearch(aList, size, skills[i]);
            if (index == size) {
                aList.add(skills[i]);
                size++;
            } else {
                aList.set(index + 1, skills[i]);
            }
        }
        System.out.println(n - size);
    }
    public static int binarySearch (ArrayList<Integer> aList, int size, int find) { // 0 - size inclusive
        int high = size;
        int low = 0;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(aList, find, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static boolean check (ArrayList<Integer> aList, int find, int index) {
        if (aList.get(index) <= find) return true;
        return false;
    }
}
