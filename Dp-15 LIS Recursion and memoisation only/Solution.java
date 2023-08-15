class Solution {

    public int recur(int[] nums,int idx,int next){
        if(idx < 0) return 0;
        int exc = recur(nums,idx-1,next);
        int inc = 0;
        if(next == nums.length || nums[idx] < nums[next] ){
            inc= recur(nums,idx-1,idx) + 1;
        }
        return Math.max(inc,exc);
    }

    public int memo(int[] nums,int idx,int next,int[][] dp){
        if(idx < 0) return 0;
        if(dp[idx][next] != 0) return dp[idx][next];

        int exc = memo(nums,idx-1,next,dp);
        int inc = 0;
        if(next == nums.length || nums[idx] < nums[next] ){
            inc= memo(nums,idx-1,idx,dp) + 1;
        }
        return dp[idx][next] = Math.max(inc,exc);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        return memo(nums,n-1,n,dp);
    }
}