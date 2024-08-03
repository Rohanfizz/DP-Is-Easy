class Solution {
    public int maxProfit(int[] prices) {
        int priceMax = prices[0];
        int priceMin = prices[0];
        int totalProfit = 0;

        for(int i =1;i<prices.length;i++){
            if(prices[i] < priceMax){
                totalProfit += priceMax-priceMin;
                priceMax = prices[i];
                priceMin = prices[i];
            }else{
                priceMax= prices[i];
            }
        }
        totalProfit += priceMax-priceMin;
        return totalProfit;
    }
}