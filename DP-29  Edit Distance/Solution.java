class Solution {

    public int recur(String s1,String s2,int i,int j){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(s1.charAt(i) == s2.charAt(j)){
            return recur(s1,s2,i-1,j-1);
        }

        int replace = 1 + recur(s1,s2,i-1,j-1);
        int insert = 1 + recur(s1,s2,i-1,j);
        int delete = 1 + recur(s1,s2,i,j-1);

        return Math.min(replace,Math.min(insert,delete));
    }

    public int memo(String s1,String s2,int i,int j,int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = memo(s1,s2,i-1,j-1,dp);
        }

        int replace = 1 + memo(s1,s2,i-1,j-1,dp);
        int insert = 1 + memo(s1,s2,i-1,j,dp);
        int delete = 1 + memo(s1,s2,i,j-1,dp);

        return dp[i][j] = Math.min(replace,Math.min(insert,delete));
    }

    public int tabulation(String s1,String s2,int[][] dp){
        int n = s1.length();
        int m = s2.length();

        for(int i = 0;i<n;i++){
            for(int j=0;j<m;j++){
                // if(i < 0) return j+1;
                // if(j < 0) return i+1;

                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = memo(s1,s2,i-1,j-1,dp);
                    continue;
                }

                int replace =0;
                if(i-1 < 0) replace = j+1;
                else if(j-1 < 0) replace = i+1;
                else replace =  1 + dp[i-1][j-1];//memo(s1,s2,i-1,j-1,dp);

                int insert = i-1 >= 0 ? 1 + dp[i-1][j] : j+1;//memo(s1,s2,i-1,j,dp);
                int delete = j-1 >= 0 ? 1 + dp[i][j-1] : i+1;//memo(s1,s2,i,j-1,dp);

                dp[i][j] = Math.min(replace,Math.min(insert,delete));
            }
        }
        return dp[n-1][m-1];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        if(n == 0 && m == 0) return 0;
        if(n == 0) return m;
        if(m == 0) return n;

        int[][] dp = new int[n][m];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        // return memo(word1,word2,n-1,m-1,dp);
        return tabulation(word1,word2,dp);
    }
}