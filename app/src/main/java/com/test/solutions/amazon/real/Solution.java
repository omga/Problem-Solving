package com.test.solutions.amazon.real;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author a.hatrus
 */

public class Solution {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String... args) {
        Solution s = new Solution();

        s.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1);
//        s.cellCompete(new int[]{1,0,0,0,1,1,0,1},6);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Object> cellCompete(int[] states, int days) {
        int[] states2 = new int[states.length];
        for (int i = 0; i <= days; i++) {
            for (int j = 0; j < states.length; j++) {
                if (j == 0) {
                    states2[j] = states[j + 1] == 0 ? 1 : 0;
                } else if (j == states.length - 1) {
                    states2[j] = states[j - 1] == 0 ? 1 : 0;
                } else {
                    states2[j] = states[j - 1] == states[j + 1] ? 1 : 0;
                }
            }
            System.arraycopy(states2, 0, states, 0, states2.length);
        }
        return Arrays.stream(states2)
                .boxed()
                .collect(Collectors.toList());
    }

}