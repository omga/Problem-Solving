package com.test.solutions.queuestack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author a.hatrus
 */
public class WallsAndGates {
    Queue<Integer> q = new LinkedList();
    Map<Pair, Integer> foundMap = new HashMap();

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms[0].length; i++) {
            for (int j = 0; j < rooms.length; j++) {
                //if inf find nearest 0
                if (isInf(rooms[i][j])) {
                    nearestDistance(i, j, rooms);
                }
            }
        }
    }

    public int nearestDistance(int i, int j, int[][] rooms) {
        int step = 1;
        offerNext(i, j, rooms);
        while (!q.isEmpty()) {
            int val = q.poll();
            if (val == 0) {
                rooms[i][j] = step;
                foundMap.put(new Pair(i, j), Integer.valueOf(step));
                return step;
            }
            offerNext(i, j, rooms);
        }
        return step;
    }

    public void offerNext(int i, int j, int[][] rooms) {
        if (i < rooms[0].length - 1 && !foundMap.containsKey(new Pair(i + 1, j)))
            q.offer(rooms[i + 1][j]);
        if (j < rooms.length - 1 && !foundMap.containsKey(new Pair(i, j + 1)))
            q.offer(rooms[i][j + 1]);
        if (j > 0 && !foundMap.containsKey(new Pair(i, j - 1))) q.offer(rooms[i][j - 1]);
        if (i > 0 && !foundMap.containsKey(new Pair(i - 1, j))) q.offer(rooms[i - 1][j]);
    }

    public boolean isInf(int val) {
        return val == 2147483647;
    }

    class Pair {
        int i;
        int j;

        public Pair(int ii, int jj) {
            i = ii;
            j = jj;
        }

        public int hashCode() {
            return i * 77 + j * 3;
        }

        public boolean equals(Object o) {
            if (o instanceof Pair) {
                return ((Pair) o).i == this.i && ((Pair) o).j == this.j;
            }
            return false;

        }
    }
}