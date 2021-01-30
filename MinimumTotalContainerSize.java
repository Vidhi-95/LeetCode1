// LC - 1335
class Solution {
    // Dynamic Programming
    public int minDifficulty(int[] jobDifficulty, int d) {
        // if number of days is more than the number of jobDifficulties, we cannot do any job
      if(d>jobDifficulty.length) return -1;
        int[][] dp = new int[d+1][jobDifficulty.length];
        for(int[] p: dp){
            // Fill the entire array with -1
            Arrays.fill(p,-1);
        }
        return dfs(jobDifficulty, d, dp, 0);
    }
    private int dfs(int[] jobDifficulty, int d, int[][]dp, int idx){
        // if there is only one day to do the job
        if(d==1){
            int max = 0;
            while(idx<jobDifficulty.length) max = Math.max(max,jobDifficulty[idx++]);
            return max;
        }
        // Finding the minimum value for the result
        if(dp[d][idx] != -1) return dp[d][idx];
        int max = 0;
        int res = Integer.MAX_VALUE;
        for(int i=idx; i<jobDifficulty.length - d + 1; i++){
            max = Math.max(max,jobDifficulty[i]);
            res = Math.min(res, max + dfs(jobDifficulty, d - 1, dp, i+1));
        }
        return dp[d][idx] = res;
    }
}