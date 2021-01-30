import java.util.*;

public class Solution {
    
    int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public int maxPathScore(int[][] matrix) {

 int m = matrix.length, n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        
        while (!que.isEmpty()) {
            int cur = que.poll();
            int x = cur / n, y = cur % n;
            
            for (int[] dir: DIRECTIONS) {
                int nxtX = x + dir[0], nxtY = y + dir[1];
                if (!isValid(m, n, nxtX, nxtY)) continue;
                
                int score = Math.min(dp[x][y], matrix[nxtX][nxtY]);
                if (score > dp[nxtX][nxtY]) {
                    dp[nxtX][nxtY] = score;
                    que.offer(nxtX * n + nxtY);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    
    private boolean isValid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}