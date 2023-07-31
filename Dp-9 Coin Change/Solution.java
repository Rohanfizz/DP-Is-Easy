class Solution {

    public int recur(int[] coins,int amt){
        //i have to return the min number
        //of coins i need to make amt
        if(amt == 0) return 0;//zero coins are req to make 0
        if(amt < 0) return 100000;

        int ans = 100000;
        for(int coin:coins){
            int remSum = amt - coin;
            int countOfMakingRemSum = recur(coins,remSum);
            ans = Math.min(ans,countOfMakingRemSum);
        }
        return ans+1;
    }

    public int memo(int[] coins,int amt,int[] dp){
        //i have to return the min number
        //of coins i need to make amt
        if(amt == 0) return 0;//zero coins are req to make 0
        if(amt < 0) return 100000;
        if(dp[amt] != 0) return dp[amt]; //recall

        int ans = 100000;
        for(int coin:coins){
            int remSum = amt - coin;
            int countOfMakingRemSum = memo(coins,remSum,dp);
            ans = Math.min(ans,countOfMakingRemSum);
        }

        return dp[amt] = ans+1;
    }

    public int tabulation(int[] coins,int amount,int[] dp){
        for(int i = 0;i<=amount;i++){
            if(i == 0){
                dp[i] = 0;
                continue;
            }

            int ans = 100000;
            for(int coin:coins){
                int remSum = i - coin;
                int countOfMakingRemSum = remSum >= 0 ? dp[remSum] : 100000;
                ans = Math.min(ans,countOfMakingRemSum);
            }

            dp[i] = ans+1;
        }
        return dp[amount];
    }


    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int ans =  tabulation(coins,amount,dp);
        if(ans >= 100000) return -1;
        return ans;
    }
}