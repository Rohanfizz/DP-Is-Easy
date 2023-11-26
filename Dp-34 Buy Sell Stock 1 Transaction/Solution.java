class Solution {
    public int maxProfit(int[] prices) {
        int currMin = Integer.MAX_VALUE;
        int ans = 0;

        for(int  i = 0;i<prices.length;i++){
            if( prices[i] < currMin){
                currMin = prices[i];
            }else{
                int profit = prices[i] - currMin;
                ans = Math.max(ans,profit);
            }
        }

        return ans;
    }
}