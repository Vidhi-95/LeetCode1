class Solution {
    private void dfs(int[][] M, int v){
        if(M[v][v] == 0) return;
        for(int i = 0; i<M.length; i++){
            if(M[v][i] == 1){
                M[v][i] = 0;
                dfs(M, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for(int i = 0; i<isConnected.length; i++){
            if(isConnected[i][i] == 1){
                count ++;
                dfs(isConnected, i);
            }
        }
        return count;
    }
    
}