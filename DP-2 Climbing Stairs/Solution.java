class Solution {

    public int recur(int n){
        if(n == 0 || n == 1) return 1;
        int nm1 = recur(n-1);
        int nm2 = recur(n-2);
        int ans = nm1 + nm2;
        return ans;
    }

    public int memo(int n,int[] dp){
        if(n == 0 || n == 1) return 1;
        //check if i already have the answer
        if(dp[n]!=0) return dp[n];

        int nm1 = memo(n-1,dp);
        int nm2 = memo(n-2,dp);
        int ans = nm1 + nm2;
        dp[n] = ans;//remember before return
        return ans;
    }

    public int tabulation(int n,int[] dp){
        for(int i = 0;i<=n;i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
                continue;
            }

            int nm1 = dp[i-1];//memo(i-1,dp);
            int nm2 = dp[i-2];//memo(i-2,dp);
            int ans = nm1 + nm2;
            dp[i] = ans;//remember before return
        }
        return dp[n];
    }

    public int spaceOpti(int n){
        if(n<=1) return 1;
        int nm1 = 1;
        int nm2 = 1;
        for(int i = 2;i<=n;i++){
            int curr = nm1 + nm2;
            if(i == n)  return curr;
            nm2 = nm1;
            nm1 = curr;
        }
        return 0;//dummy
    }

    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // return recur(n);
        // return memo(n,dp);
        // return tabulation(n,dp);
        return spaceOpti(n);
    }
}