package com.test.solutions;

/**
 * @author a.hatrus
 */

public class Palindrome {

    public static void main(String[] args) {
        System.out.println("args " + args.length);
        System.out.println("args " + args[0]);
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "aa";
        Solution solution = new Solution();
        System.out.println("p1 " + solution.isPalindrome(s1));
        System.out.println("p2 " + solution.isPalindrome(s2));
        System.out.println("p3 " + solution.isPalindrome(s3));
    }

    static class Solution {
        final int UPPER_A = 65;
        final int UPPER_Z = 90;
        final int LOWER_A = 97;
        final int LOWER_Z = 122;
        final int ZERO = 48;
        final int NINE = 57;

        public boolean isPalindrome(String s) {
            int N = s.length();
            if (N <= 1) {
                return true;
            }
            char[] str = s.toCharArray();
            int i = 0;
            int j = N - 1;
            do {
                char first = str[i];
                char last = str[j];
                if (!isAlphanumeric(first)) {
                    if (!isUpperCase(first)) {
                        i++;
                        continue;
                    } else
                        first += 32;
                }
                if (!isAlphanumeric(last)) {
                    if (!isUpperCase(last)) {
                        j--;
                        continue;
                    } else
                        last += 32;
                }
                if (first != last)
                    return false;
                i++;
                j--;
            } while (i < j);

            return true;
        }

        public boolean isAlphanumeric(char c) {
            return (c >= LOWER_A && c <= LOWER_Z) || (c >= ZERO && c <= NINE);
        }

        public boolean isUpperCase(char c) {
            return c >= UPPER_A && c <= UPPER_Z;
        }
    }
}
