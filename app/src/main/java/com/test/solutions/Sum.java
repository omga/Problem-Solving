package com.test.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author a.hatrus
 */

public class Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1, 9};
        System.out.println("sum1: " + sumArr(1, arr));
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("sum1: " + size(list, arr.length));
    }

    public static int sumArr(int i, int[] arr) {
        if (arr.length == i)
            return arr[i - 1];
        return arr[i - 1] + sumArr(i + 1, arr);
    }

    public static int size(List list, int i) {
        if (list.isEmpty())
            return 0;

        return 1 + size(list.subList(0, i - 2), i - 1);
    }
}
