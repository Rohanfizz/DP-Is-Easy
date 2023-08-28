class Solution {

    public boolean recur(String s,int sp,int ep){
        if(sp == ep) return true;
        if(sp > ep) return true;
        if(s.charAt(sp) != s.charAt(ep)) return false;

        return recur(s,sp+1,ep-1);
    }
    //dp[sp][ep] == 1; true
    //dp[sp][ep] == 0; we have not calculated
    //dp[sp][ep] == -1; false
    public boolean memo(String s,int sp,int ep,int[][] dp){
        if(sp == ep) return true;
        if(sp > ep) return true;
        if(dp[sp][ep] != 0) return dp[sp][ep]==1;
        if(s.charAt(sp) != s.charAt(ep)) return false;

        dp[sp][ep] = memo(s,sp+1,ep-1,dp) ? 1 : -1;
        return dp[sp][ep] == 1;
    }
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        //Generate all the substrings
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                boolean isPali = memo(s,i,j,dp);
                if(isPali) cnt++;
            }
        }
        return cnt;
    }
}