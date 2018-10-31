package com.test.solutions;

import java.util.Arrays;

/**
 * @author a.hatrus
 */

public class ReverseWords {

    public static void main(String... args) {
        char[] str = {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'};
        ReverseWords r = new ReverseWords();
        System.out.print("arr1: " + Arrays.toString(r.reverseWords(str)));

    }

    public char[] reverseWords(char[] str) {
        int N = str.length;
        char[] res = new char[N];
        int latestWordIndex = N;
        int destPos = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                System.arraycopy(str, i + 1, res, destPos, latestWordIndex - i - 1);
                destPos += latestWordIndex - i;
                res[destPos - 1] = ' ';
                latestWordIndex = i;
            }
        }
        System.arraycopy(str, 0, res, destPos, latestWordIndex);
        return res;
    }
}
