class Solution {
    public int recur(int[] coins,int i,int amt){
        if(amt == 0) return 1;
        if(amt < 0) return 0;
        if(i == coins.length) return 0;

        int stay = recur(coins,i,amt-coins[i]);
        int move = recur(coins,i+1,amt);
        return stay+move;
    }
    public int memo(int[] coins,int i,int amt,int[][] dp){
        if(amt == 0) return 1;
        if(amt < 0) return 0;
        if(i == coins.length) return 0;
        if(dp[i][amt] != -1) return dp[i][amt];

        int stay = memo(coins,i,amt-coins[i],dp);
        int move = memo(coins,i+1,amt,dp);
        return dp[i][amt] = stay+move;
    }
    public int tabulation(int[] coins,int amount,int[][] dp){
        for(int i = coins.length-1;i>=0;i--){
            for(int amt = 0;amt<=amount;amt++){
                if(amt == 0){
                    dp[i][amt] = 1;
                    continue;
                }

                int stay = (amt-coins[i] >=0) ? dp[i][amt-coins[i]] : 0;
                int move = i+1<coins.length ? dp[i+1][amt] : 0;
                dp[i][amt] = stay+move;
            }
        }
        return dp[0][amount];
    }
    
    public int spaceOptimization(int[] coins,int  amount){
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins){
            for(int amt = 1;amt <= amount;amt++){
                int remAmount = amt - coin;
                if(remAmount<0) continue;
                dp[amt] += dp[remAmount];
            }
        }
        return dp[amount];
    }

    public int change(int amount, int[] coins) {
        // int[][] dp = new int[coins.length][amount+1];
        // for(int i = 0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // // return recur(coins,0,amount);
        // // return memo(coins,0,amount,dp);
        // return tabulation(coins,amount,dp);
        return spaceOptimization(coins,amount);
    }
}