class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new  boolean[n][n];

        for(int gap = 0;gap<n;gap++){
            for(int sp = 0,ep=gap; ep<n ; sp++,ep++){
                if(gap == 0){
                    dp[sp][ep] = true;
                }else if(gap == 1){
                    dp[sp][ep] = s.charAt(sp) == s.charAt(ep);
                }else{
                   if(s.charAt(sp) == s.charAt(ep)){
                       dp[sp][ep] = dp[sp+1][ep-1];
                   }
                }
            }
        }

        int cnt  = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(dp[i][j] == true) cnt++;
            }
        }
        return cnt;
    }
}