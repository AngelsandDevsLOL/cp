package COCI;

import java.util.HashMap;
import java.util.Scanner;

public class Kemjia {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] input = (sc.nextLine()).split("->");
            String[] left = input[0].split("\\+");
            String[] right = input[1].split("\\+");
            HashMap<Character, Integer> leftMap = new HashMap<>();
            HashMap<Character, Integer> rightMap = new HashMap<>();
            for (int j = 0; j < left.length; j++) {
                int coefficient = 1;
                for (int k = 0; k < left[j].length(); k++) {
                    char x = left[j].charAt(k);
                    if (k == 0) {
                        if (x <= 57 && x >= 50) { // a number
                            coefficient = Integer.parseInt(String.valueOf(x));
                        } else {
                            if (k != left[j].length() - 1 && left[j].charAt(k + 1) <= 57 && left[j].charAt(k + 1) >= 50) { // not the last one
                                if (leftMap.containsKey(x)) {
                                    leftMap.put(x, leftMap.get(x) + (coefficient * Integer.parseInt(String.valueOf(left[j].charAt(k + 1)))));
                                } else {
                                    leftMap.put(x, (coefficient * Integer.parseInt(String.valueOf(left[j].charAt(k + 1)))));
                                }
                                k++;
                            } else { // first letter, not a number, and the last character = character
                                if (leftMap.containsKey(x)) {
                                    leftMap.put(x, leftMap.get(x) + (coefficient));
                                } else {
                                    leftMap.put(x, (coefficient));
                                }
                            }
                        }
                    } else {
                        if (k != left[j].length() - 1 && left[j].charAt(k + 1) <= 57 && left[j].charAt(k + 1) >= 50) { // not the last one
                            if (leftMap.containsKey(x)) {
                                leftMap.put(x, leftMap.get(x) + (coefficient * Integer.parseInt(String.valueOf(left[j].charAt(k + 1)))));
                            } else {
                                leftMap.put(x, (coefficient * Integer.parseInt(String.valueOf(left[j].charAt(k + 1)))));
                            }
                            k++;
                        } else { // first letter, not a number, and the last character = character
                            if (leftMap.containsKey(x)) {
                                leftMap.put(x, leftMap.get(x) + (coefficient));
                            } else {
                                leftMap.put(x, (coefficient));
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < right.length; j++) {
                int coefficient = 1;
                for (int k = 0; k < right[j].length(); k++) {
                    char x = right[j].charAt(k);
                    if (k == 0) {
                        if (x <= 57 && x >= 50) { // a number
                            coefficient = Integer.parseInt(String.valueOf(x));
                        } else {
                            if (k != right[j].length() - 1 && right[j].charAt(k + 1) <= 57 && right[j].charAt(k + 1) >= 50) { // not the last one
                                if (rightMap.containsKey(x)) {
                                    rightMap.put(x, rightMap.get(x) + (coefficient * Integer.parseInt(String.valueOf(right[j].charAt(k + 1)))));
                                } else {
                                    rightMap.put(x, (coefficient * Integer.parseInt(String.valueOf(right[j].charAt(k + 1)))));
                                }
                                k++;
                            } else { // first letter, not a number, and the last character = character
                                if (rightMap.containsKey(x)) {
                                    rightMap.put(x, rightMap.get(x) + (coefficient));
                                } else {
                                    rightMap.put(x, (coefficient));
                                }
                            }
                        }
                    } else {
                        if (k != right[j].length() - 1 && right[j].charAt(k + 1) <= 57 && right[j].charAt(k + 1) >= 50) { // not the last one
                            if (rightMap.containsKey(x)) {
                                rightMap.put(x, rightMap.get(x) + (coefficient * Integer.parseInt(String.valueOf(right[j].charAt(k + 1)))));
                            } else {
                                rightMap.put(x, (coefficient * Integer.parseInt(String.valueOf(right[j].charAt(k + 1)))));
                            }
                            k++;
                        } else { // first letter, not a number, and the last character = character
                            if (rightMap.containsKey(x)) {
                                rightMap.put(x, rightMap.get(x) + (coefficient));
                            } else {
                                rightMap.put(x, (coefficient));
                            }
                        }
                    }
                }
            }
            boolean bool = true;
            if (leftMap.size() != rightMap.size()) {
                bool = false;
            } else {
                for (char x : leftMap.keySet()) {
                    if (!rightMap.containsKey(x) || rightMap.get(x) != leftMap.get(x)) {
                        bool = false;
                    }
                }
            }
            if (bool) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}
