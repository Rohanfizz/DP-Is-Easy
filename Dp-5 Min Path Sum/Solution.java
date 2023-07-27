class Solution {
    public int recur(int[][] grid,int i,int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }

        int right = recur(grid,i,j+1);
        int down = recur(grid,i+1,j);
        return Math.min(right,down) + grid[i][j];
    }

    public int memo(int[][] grid,int i ,int j ,int[][] dp){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1) return dp[i][j];

        int right = memo(grid,i,j+1,dp);
        int down = memo(grid,i+1,j,dp);

        return dp[i][j] = Math.min(right,down) + grid[i][j];
    }
    public int tabulation(int[][] grid,int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                // if(i<0 || j<0 || i==grid.length || j==grid[0].length){
                //     return Integer.MAX_VALUE;
                // }
                if(i == grid.length-1 && j == grid[0].length-1){
                    dp[i][j] = grid[i][j]; 
                    continue;
                }

                int right = j+1 < m ? dp[i][j+1] : Integer.MAX_VALUE;//memo(grid,i,j+1,dp);
                int down = i+1 < n ? dp[i+1][j] : Integer.MAX_VALUE;//memo(grid,i+1,j,dp);

                dp[i][j] = Math.min(right,down) + grid[i][j];
            }
        }
        return dp[0][0];
    }
    public int minPathSum(int[][] grid) {
        int[][] dp= new int[grid.length][grid[0].length];
        for(int i = 0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        // return recur(grid,0,0);
        // return memo(grid,0,0,dp);
        return tabulation(grid,dp);
    }
}