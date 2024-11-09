import java.util.PriorityQueue;
import java.util.Arrays;

public class B_minTime {

    public static void main(String[] args) {
        int[][] movetime = {
            {1, 4, 4},
            {2, 0, 2},
            {5, 1, 6}
        };
        
        Solution sol = new Solution();
        System.out.println(sol.minTime(movetime));  // Expected output depends on the grid
    }

    static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }

        @Override
        public int compareTo(Pair other) {
            return this.time - other.time;
        }
    }

    public static class Solution {
        public int minTime(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int[][] dist = new int[n][m];
            
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            dist[0][0] = matrix[0][0];
            pq.add(new Pair(0, 0, matrix[0][0]));

            while (!pq.isEmpty()) {
                Pair rem = pq.poll();
                int r = rem.row, c = rem.col, t = rem.time;

                if (r == n - 1 && c == m - 1) {
                    return t;
                }

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        int totalTime = Math.max(t, matrix[newRow][newCol]) + 1;

                        if (dist[newRow][newCol] > totalTime) {
                            dist[newRow][newCol] = totalTime;
                            pq.add(new Pair(newRow, newCol, totalTime));
                        }
                    }
                }
            }
            return -1;  // If destination is unreachable
        }
    }
}
