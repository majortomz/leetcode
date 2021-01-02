package jd;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            char[] chars = sc.next().toCharArray();
            if (canSwap(chars)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean canSwap(char[] chars) {
        int openCount = 0;
        int firstCloseIndex = -1, lastOpenIndex = -1;
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                openCount++;
                lastOpenIndex = i;
            } else {
                firstCloseIndex = (firstCloseIndex == -1 ? i : firstCloseIndex);
                openCount--;
            }
        }

        if(openCount != 0)  return false;

        chars[firstCloseIndex] = '(';
        chars[lastOpenIndex] = ')';
        for(char c : chars) {
            if (c == '(') {
                openCount++;
            } else {
                openCount--;
            }
        }
        return openCount == 0;
    }

    static boolean canSwap2(char[] chars) {
        int openCount = 0;
        int lastOpenIndex = -1, firstCloseIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                openCount++;
                lastOpenIndex = i;
            } else {
                firstCloseIndex = (firstCloseIndex == -1 ? i : firstCloseIndex);
                openCount--;
            }
        }
        if (openCount != 0) {
            return false;
        }

        int firstConflictIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                openCount++;
            } else {
                openCount--;
            }
            if (openCount < 0) {
                firstConflictIndex = i;
                break;
            }
        }
        if (firstConflictIndex == -1) return true;

        chars[lastOpenIndex] = ')';
        chars[firstCloseIndex] = '(';

        openCount = 0;
        for (char c : chars) {
            if (c == '(') {
                openCount++;
            } else {
                openCount--;
            }
            if (openCount < 0) {
                return false;
            }
        }
        return true;
    }
}
