package com.test.solutions.amazon.real;

/**
 * @author a.hatrus
 */
class GCD {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public int generalizedGCD(int num, int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > min) min = arr[i];
        }

        while (min > 1) {
            boolean failed = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % min != 0) {
                    failed = true;
                    break;
                }
            }
            if (!failed) return min;
            double sqrt = Math.sqrt(min);
            if (Math.floor(sqrt) == 0) {
                min = (int) sqrt;
                continue;
            } else {
                int whole = (int) sqrt;
                while (min % whole != 0) {
                    whole--;
                }
                min = whole;
            }
        }
        return 1;
    }
    // METHOD SIGNATURE ENDS
}