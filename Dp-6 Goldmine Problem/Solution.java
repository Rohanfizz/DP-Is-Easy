//User function Template for Java

class Solution{
    
    static int recur(int[][] arr,int i,int j){
        int n = arr.length;
        int m = arr[0].length;
        if(i<0 || j>=m || i>=n) return 0;
        
        int diagUp = recur(arr,i-1,j+1);
        int right = recur(arr,i,j+1);
        int diagDown = recur(arr,i+1,j+1);
        
        return Math.max(right, Math.max( diagUp , diagDown ) ) + arr[i][j];
    }
    
    static int memo(int[][] arr,int i,int j,int[][] dp){
        int n = arr.length;
        int m = arr[0].length;
        if(i<0 || j>=m || i>=n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int diagUp = memo(arr,i-1,j+1,dp);
        int right = memo(arr,i,j+1,dp);
        int diagDown = memo(arr,i+1,j+1,dp);
        
        return dp[i][j] = Math.max(right, Math.max( diagUp , diagDown ) ) + arr[i][j];
    }
    static int tabulation(int[][] arr,int[][] dp){
        int n = arr.length;
        int m = arr[0].length;
        for(int j = m-1;j>=0;j--){
            for(int i = 0;i<n;i++){
                //base
                if(j == m-1){
                    dp[i][j] = arr[i][j];
                }else{
                    int diagUp = i-1>=0 && j+1<m ? dp[i-1][j+1] : 0;
                    int right = j+1<m ? dp[i][j+1] : 0;
                    int diagDown = i+1<n && j+1<m ? dp[i+1][j+1] : 0;
                    dp[i][j] = Math.max(right, Math.max( diagUp , diagDown ) ) + arr[i][j];
                }
            }
        }
        int maxi = 0;
        for(int i = 0;i<n;i++){
            maxi =Math.max(maxi,dp[i][0]);
        }
        return maxi;
    }
    static int maxGold(int n, int m, int arr[][]){
        // code here
        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return tabulation(arr,dp);
        // int maxi = 0;
        // for(int i = 0;i<n;i++){
        //     int goldICanGetIfIStartOnThisRow = memo(arr,i,0,dp);
        //     maxi = Math.max(goldICanGetIfIStartOnThisRow,maxi);
        // }
        // return maxi;
    }
    
    
    
    
    
    
    
    
    
    
    
}