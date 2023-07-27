class Solution {
    public int recur(int[] arr,int i){
        if(i>=arr.length) return 0;

        int inc = arr[i] + recur(arr,i+2);
        int exc = recur(arr,i+1);

        return Math.max(inc,exc);
    }
    public int memo(int[] arr,int i,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i] != -1) return dp[i];

        int inc = arr[i] + memo(arr,i+2,dp);
        int exc = memo(arr,i+1,dp);

        return dp[i] = Math.max(inc,exc);//remembered the answer for ith house
    }
    public int tabulation(int[] arr,int[] dp){
        for(int i = arr.length-1;i>=0;i--){
            // if(i>=arr.length) return 0;

            int inc = arr[i] + (i+2 >= arr.length?0:dp[i+2]);
            int exc = (i+1>=arr.length?0:dp[i+1]);

            dp[i] = Math.max(inc,exc);
        }
        return dp[0];
    }

    public int spaceOpti(int[] nums){
        int prevInc = 0;
        int prevExc = 0;
        for(int i = 0;i<nums.length;i++){
            int currInc = nums[i] + prevExc;
            int currExc = Math.max(prevInc,prevExc);
            //This ith house will become prev for the
            //next house, so update variables
            prevInc = currInc;
            prevExc = currExc;
        }
        return Math.max(prevInc,prevExc);
    }

    public int rob(int[] nums) {
        // int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // return recur(nums,0);
        // return memo(nums,0,dp);
        // return tabulation(nums,dp);
        return spaceOpti(nums);
    }
}