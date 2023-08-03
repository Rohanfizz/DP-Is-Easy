
class Solution 
{ 
    static int recur(int[] val,int[] wt,int i,int remWt){
        if(remWt < 0) return Integer.MIN_VALUE;
        if(remWt == 0) return 0;// cannot add anymore items in bag
        if(i == val.length) return 0;// am left with no more items
        
        //include
        int include = recur(val,wt,i+1,remWt-wt[i]) + val[i];
        //exclude
        int exclude = recur(val,wt,i+1,remWt);
        return Math.max(include,exclude);
    }
    
    static int memo(int[] val,int[] wt,int i,int remWt,int[][] dp){
        if(remWt < 0) return Integer.MIN_VALUE;
        if(remWt == 0) return 0;// cannot add anymore items in bag
        if(i == val.length) return 0;// am left with no more items
        if(dp[i][remWt] != -1) return dp[i][remWt];
        //include
        int include = memo(val,wt,i+1,remWt-wt[i],dp) + val[i];
        //exclude
        int exclude = memo(val,wt,i+1,remWt,dp);
        return dp[i][remWt] = Math.max(include,exclude);
    }
    
    static int tabulation(int[] val,int[] wt,int[][] dp,int W){
        int n = val.length;
        for(int i = n-1;i>=0;i--){
            for(int remWt = 0;remWt<=W;remWt++){
                
                if(remWt == 0){
                    dp[i][remWt] = 0;
                    continue;
                }
                
                //include memo(val,wt,i+1,remWt-wt[i],dp) 
                int include = val[i];
                
                if(remWt-wt[i] < 0) include = Integer.MIN_VALUE;
                else if(i+1 == n || remWt-wt[i]==0) include += 0;
                else include += dp[i+1][remWt-wt[i]];
                //exclude//memo(val,wt,i+1,remWt,dp);
                int exclude = i+1<n ? dp[i+1][remWt] : 0;
                dp[i][remWt] = Math.max(include,exclude);
            }
        }
        return dp[0][W];
    }
    
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) { 
         // your code here 
         int[][] dp = new int[n][W+1];
         for(int i = 0;i<n;i++){
             Arrays.fill(dp[i],-1);
         }
        //  return memo(val,wt,0,W,dp);
        return tabulation(val,wt,dp,W);
    } 
}


