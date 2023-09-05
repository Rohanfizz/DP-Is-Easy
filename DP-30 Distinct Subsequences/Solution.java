class Solution {

    public int recur(String s,String t,int i,int j){
        int md = 1000000007;
        if(j == t.length()){
            //string t is finished, this means that
            // i was able to match all the chars of t using a subseq of string s
            return 1;//I have found a way to make string t
        }
        if(i == s.length()){
            //i am still having some chars in t but there are no more chars
            //in string s, hence ill not be able to find any subseq
            return 0;
        }

        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = recur(s,t,i+1,j+1);
        }

        int nottake = recur(s,t,i+1,j);

        return (take + nottake)%md;
    }

    public int memo(String s,String t,int i,int j,int[][] dp){
        int md = 1000000007;
        if(j == t.length()){
            //string t is finished, this means that
            // i was able to match all the chars of t using a subseq of string s
            return 1;//I have found a way to make string t
        }
        if(i == s.length()){
            //i am still having some chars in t but there are no more chars
            //in string s, hence ill not be able to find any subseq
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];//recall

        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = memo(s,t,i+1,j+1,dp);
        }

        int nottake = memo(s,t,i+1,j,dp);

        return dp[i][j] = (take + nottake)%md;
    }

    public int tabulation(String s,String t,int[][] dp){
        int md = 1000000007;
        for(int i = s.length()-1;i>=0;i--){
            for(int j = t.length()-1;j>=0;j--){

                int take = 0;
                if(s.charAt(i) == t.charAt(j)){
                    if(j+1 == t.length()) take =1;
                    else if(i+1 == s.length()) take = 0;
                    else take = dp[i+1][j+1];//memo(s,t,i+1,j+1,dp);
                }

                int nottake = i+1 < s.length() ? dp[i+1][j] : 0;//memo(s,t,i+1,j,dp);

                dp[i][j] = (take + nottake)%md;
            }
        }
        return dp[0][0];
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        // return memo(s,t,0,0,dp);
        // return recur(s,t,0,0)%md;
        return tabulation(s,t,dp);
    }
}