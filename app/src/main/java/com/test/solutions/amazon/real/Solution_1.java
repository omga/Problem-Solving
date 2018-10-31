package com.test.solutions.amazon.real;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author a.hatrus
 */
public class Solution_1 {

    public static void main(String... args) {
        Solution_1 s = new Solution_1();
//        s.cellCompete(new int[]{1, 0, 0, 0, 0, 1, 0, 0}, 1);
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
        // WRITE YOUR CODE HERE
        Queue<Cell> q = new LinkedList();
        // for(int i = 0; i < numRows; i++)
        //     for(int j =0; j < numColumns; j++) {
        //         if(area.get(i).get(j) == 1) {
        //             queue.offer(Cell(i,j, step);
        //         }
        //     }
        q.offer(new Cell(0, 0, 0));
        Integer value = area.get(0).get(0);
        value = -1;

        while (!q.isEmpty()) {
            Cell cell = q.poll();
            if (area.get(cell.i).get(cell.j) == 9)
                return cell.step;
            int steps = cell.step + 1;
            if (cell.i < numRows - 1 && shouldVisit(cell.i + 1, cell.j, area)) {
                q.offer(new Cell(cell.i + 1, cell.j, steps));
                Integer val = area.get(cell.i + 1).get(cell.j);
                val = -1;
            }
            if (cell.j < numColumns - 1 && shouldVisit(cell.i, cell.j + 1, area)) {
                q.offer(new Cell(cell.i, cell.j + 1, steps));
                Integer val = area.get(cell.i).set(cell.j + 1, -1);
                val = -1;
            }
            if (cell.i > 0 && shouldVisit(cell.i - 1, cell.j, area)) {
                q.offer(new Cell(cell.i - 1, cell.j, steps));
                Integer val = area.get(cell.i - 1).get(cell.j);
                val = -1;
            }
            if (cell.j > 0 && shouldVisit(cell.i, cell.j - 1, area)) {
                q.offer(new Cell(cell.i, cell.j - 1, steps));
                Integer val = area.get(cell.i).get(cell.j - 1);
                val = -1;
            }
        }
        return -1;
    }
    // METHOD SIGNATURE ENDS

    boolean shouldVisit(int i, int j, List<List<Integer>> area) {
        return area.get(i).get(j) == 1 || area.get(i).get(j) == 9;
    }

    class Cell {
        int i;
        int j;
        int step;

        public Cell(int ii, int jj, int stepp) {
            i = ii;
            j = jj;
            step = stepp;
        }
    }
}
