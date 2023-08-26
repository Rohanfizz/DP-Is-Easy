class Solution {
    public int recur(String s,int sp,int ep){
        if(sp  == ep) return 1;
        if(sp + 1 == ep){
            if(s.charAt(sp) == s.charAt(ep)) return 2;
            return 1;
        }

        if(s.charAt(sp) == s.charAt(ep)){
            return recur(s,sp+1,ep-1) + 2;
        }
        int option1 = recur(s,sp,ep-1);
        int option2 = recur(s,sp+1,ep);

        return Math.max(option1,option2);
    }
    public int memo(String s,int sp,int ep,int[][] dp){
        if(sp  == ep) return 1;
        if(sp + 1 == ep){
            if(s.charAt(sp) == s.charAt(ep)) return 2;
            return 1;
        }
        if(dp[sp][ep]!=0) return dp[sp][ep];

        if(s.charAt(sp) == s.charAt(ep)){
            return dp[sp][ep]=memo(s,sp+1,ep-1,dp) + 2;
        }
        int option1 = memo(s,sp,ep-1,dp);
        int option2 = memo(s,sp+1,ep,dp);

        return dp[sp][ep]=Math.max(option1,option2);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // return recur(s,0,n-1);
        // return memo(s,0,n-1,dp);
        for(int gap = 0;gap<n;gap++){
            for(int sp = 0,ep = gap;ep<n;sp++,ep++){
                if(sp == ep){
                    dp[sp][ep]=  1;
                }else if(sp+1 == ep){
                    dp[sp][ep] = s.charAt(sp) == s.charAt(ep) ? 2 : 1;
                }else{
                    if(s.charAt(sp) == s.charAt(ep)){
                        dp[sp][ep] = dp[sp+1][ep-1] + 2;
                    }else{
                        dp[sp][ep] = Math.max(dp[sp+1][ep],dp[sp][ep-1]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}








