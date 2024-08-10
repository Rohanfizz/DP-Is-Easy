class Solution {
    public int recur(int[] prices,int fee,int idx,int state){
        if(idx == 0){
            if(state == 0) return - prices[idx];
            else return 0;
        }

        if(state == 0){
            int buyToday = recur(prices,fee,idx-1,1) - prices[idx];
            int doNotBuyToday = recur(prices,fee,idx-1,0);
            return Math.max(buyToday,doNotBuyToday);
        }else if(state == 1){
            int sellToday = prices[idx] + recur(prices,fee,idx-1,0) - fee;
            int doNotSellToday = recur(prices,fee,idx-1,1);
            return Math.max(sellToday,doNotSellToday);
        }
        return 0; //Dummy return
    }
    public int memo(int[] prices,int fee,int idx,int state,int[][] dp){
        if(idx == 0){
            if(state == 0) return - prices[idx];
            else return 0;
        }

        if(dp[idx][state] != -1) return dp[idx][state];

        if(state == 0){
            int buyToday = memo(prices,fee,idx-1,1,dp) - prices[idx];
            int doNotBuyToday = memo(prices,fee,idx-1,0,dp);
            return dp[idx][state] = Math.max(buyToday,doNotBuyToday);
        }else if(state == 1){
            int sellToday = prices[idx] + memo(prices,fee,idx-1,0,dp) - fee;
            int doNotSellToday = memo(prices,fee,idx-1,1,dp);
            return dp[idx][state] = Math.max(sellToday,doNotSellToday);
        }
        return 0; //Dummy return
    }

    public int tabulation(int[] prices,int fee,int[][] dp){
        for(int idx = 0;idx<prices.length;idx++){
            for(int state = 0;state<2;state++){
                if(idx == 0){
                    if(state == 0) dp[idx][state] = -prices[idx];
                    else dp[idx][state] = 0;
                    continue;
                }

                if(state == 0){
                    int buyToday = dp[idx-1][1] - prices[idx];
                    int doNotBuyToday = dp[idx-1][0];
                    dp[idx][state] = Math.max(buyToday,doNotBuyToday);
                }else if(state == 1){
                    int sellToday = prices[idx] + dp[idx-1][0] - fee;
                    int doNotSellToday =  dp[idx-1][1];
                    dp[idx][state] = Math.max(sellToday,doNotSellToday);
                }
            }
        }
        return dp[prices.length-1][1];
    }

    public int maxProfit(int[] prices, int fee) {
        // return recur(prices,fee,prices.length-1,1);
        int[][] dp = new int[prices.length][2];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return tabulation(prices,fee,dp);
        // return memo(prices,fee,prices.length-1,1,dp);
    }
}