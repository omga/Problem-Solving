package com.test.solutions.amazon.strings;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author a.hatrus
 */
class Solution1_1 {
    public static void main(String... args) {
        new Solution1_1().firstUniqChar("cc");
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> charsMap = new HashMap<>();
        Set<Integer> uniqueSet = new LinkedHashSet<>();
        uniqueSet.add(-1);
        for (int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            if (!charsMap.containsKey(c)) {
                charsMap.put(c, i);
                uniqueSet.add(i);
            } else {
                uniqueSet.remove(charsMap.get(c));
            }
        }
        return (int) uniqueSet.toArray()[uniqueSet.size() - 1];
    }

}