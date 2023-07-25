class Solution {

    public int recur(int[] cost,int i){
        if(i == cost.length) return 0;//already on top
        if(i >  cost.length) return Integer.MAX_VALUE; //i have exceeded

        int ip1 = recur(cost,i+1);
        int ip2 = recur(cost,i+2);
        
        return Math.min(ip1,ip2) + cost[i];

    }

    public int memo(int[] cost,int i,int[] dp){
        if(i == cost.length) return 0;//already on top
        if(i >  cost.length) return Integer.MAX_VALUE; //i have exceeded

        if(dp[i] != -1) return dp[i];

        int ip1 = memo(cost,i+1,dp);
        int ip2 = memo(cost,i+2,dp);
        
        dp[i] =  Math.min(ip1,ip2) + cost[i];
        return Math.min(ip1,ip2) + cost[i];
    }
    public int tabulation(int[] cost,int[] dp){
        for(int i = cost.length-1;i>=0;i--){
            // if(i == cost.length) return 0;//already on top
            // if(i >  cost.length) return Integer.MAX_VALUE; //i have exceeded

            int ip1 = i+1 == cost.length? 0 : dp[i+1];//memo(cost,i+1,dp);
            
            int ip2;
            if(i+2 ==cost.length) ip2 = 0;
            else if(i+2 > cost.length) ip2 = Integer.MAX_VALUE;
            else ip2 = dp[i+2];
            
            dp[i] =  Math.min(ip1,ip2) + cost[i];
        }
        return Math.min(dp[0],dp[1]);
    }
    public int spaceOptimization(int[] cost){
        //If im standing on ith index, I only want to access the (i+1)th and (i+2)th index answers
        //The variables "ip1" and "ip2" will be remembering the answer to (i+1)th and (i+2)th indexes
        int ip1 = 0;                                
        int ip2 = Integer.MAX_VALUE;
        for(int i = cost.length-1;i>=0;i--){
            int curr = Math.min(ip1,ip2) + cost[i];//Calculating the answer for current Index
            //Moving Ip2 and Ip1 backwards
            ip2 = ip1;
            ip1 = curr;
        }
        //In the end, Ip1 will be having the answer to 0th index,
        //and Ip2 will be having the answer to 1th index, return the min of them
        return Math.min(ip1,ip2);
    }
    public int minCostClimbingStairs(int[] cost) {
        // return Math.min(recur(cost,0) , recur(cost,1));
        // int[] dp = new int[cost.length];
        // Arrays.fill(dp,-1);
        // return tabulation(cost,dp);
        // return Math.min(memo(cost,0,dp) , memo(cost,1,dp));
        return spaceOptimization(cost);
    }
}