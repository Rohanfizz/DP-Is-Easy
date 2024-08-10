class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] bestIfSellToday = new int[n];
        int[] bestIfSellTodayOrBefore = new int[n];

        int minsf = prices[0];
        for(int i = 1;i<n;i++){
            if(prices[i] < minsf){
                minsf = prices[i];
            }
            bestIfSellToday[i] = prices[i] - minsf;
            bestIfSellTodayOrBefore[i] = Math.max(bestIfSellToday[i],bestIfSellTodayOrBefore[i-1]);
        }

        int[] bestIfBuyToday = new int[n];
        int[] bestIfBuyTodayOrAfter = new int[n];

        int maxsf = prices[n-1];
        for(int i = n-2;i>=0;i--){
            if(prices[i] > maxsf){
                maxsf = prices[i];
            }
            bestIfBuyToday[i] = maxsf - prices[i];
            bestIfBuyTodayOrAfter[i] = Math.max(bestIfBuyToday[i],bestIfBuyTodayOrAfter[i]);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            ans = Math.max(ans,bestIfSellTodayOrBefore[i]+bestIfBuyTodayOrAfter[i]);
        }
        return ans;
    }
}