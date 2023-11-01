class Solution {

    public int recur(int i,int j,String s1,String s2){
        if(i == s1.length() && j == s2.length()) return 0;
        if(i == s1.length()) return s2.length()-j;
        if(j == s2.length()) return s1.length()-i;

        if(s1.charAt(i) == s2.charAt(j)) return recur(i+1,j+1,s1,s2);

        int option1 = 1 + recur(i+1,j,s1,s2);
        int option2 = 1 + recur(i,j+1,s1,s2);

        return Math.min(option1,option2);
    }

    public int memo(int i,int j,String s1,String s2,int[][] dp){
        if(i == s1.length() && j == s2.length()) return 0;
        if(i == s1.length()) return s2.length()-j;
        if(j == s2.length()) return s1.length()-i;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return memo(i+1,j+1,s1,s2,dp);

        int option1 = 1 + memo(i+1,j,s1,s2,dp);
        int option2 = 1 + memo(i,j+1,s1,s2,dp);

        return dp[i][j] = Math.min(option1,option2);
    }

    public int getDPij(int[][]  dp,int i,int  j){
        int n = dp.length;
        int m = dp[0].length;
        if(i == n && j == m) return 0;
        if(i == n) return m-j;
        if(j == m) return n-i;
        return dp[i][j];
    }

    public int tabulation(String s1,String s2,int[][] dp){
        for(int i = s1.length()-1;i>=0;i--){
            for(int j = s2.length()-1;j>=0;j--){

                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = getDPij(dp,i+1,j+1);//memo(i+1,j+1,s1,s2,dp);
                    continue;
                }

                int option1 = 1 + getDPij(dp,i+1,j);//memo(i+1,j,s1,s2,dp);
                int option2 = 1 +getDPij(dp,i,j+1);//memo(i,j+1,s1,s2,dp);

                dp[i][j] = Math.min(option1,option2);
            }
        }
        return dp[0][0];
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        // for(int i = 0;i<dp.length;i++) Arrays.fill(dp[i],-1);
        // return recur(0,0,word1,word2);
        // return memo(0,0,word1,word2,dp);
        return tabulation(word1,word2,dp);
    }
}