package com.test.solutions;

/**
 * @author a.hatrus
 */
public class CodeForces1 {

    public static void main(String[] s) {
        int n = Integer.parseInt(s[0].split(" ")[0]);
        int k = Integer.parseInt(s[0].split(" ")[1]);
        String t = s[1];

        int start = n / 2 - 1;
        int end = n - 1;
        int commonChars = 0;
        int numberOfChecks = 0;
        while (start >= 0) {
            if (t.charAt(start) == t.charAt(end)) {
                commonChars++;
                start--;
                end--;
            } else {
                commonChars = 0;
                end = n;
                numberOfChecks++;
            }
            start -= numberOfChecks;
        }
        StringBuilder sb = new StringBuilder(t);
        String appendix = t.substring(commonChars, n);
        for (int i = 0; i < k - 1; i++) {
            sb.append(appendix);
        }
        System.out.print(sb);
    }
}
