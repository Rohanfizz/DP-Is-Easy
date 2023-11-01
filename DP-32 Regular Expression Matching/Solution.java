class Solution {

    public boolean recur(String s,String p,int i,int j){
        if(i == s.length() && j == p.length()) return true; //Both the strings were able to match
        if(j == p.length()) return false; //pattern is empty, but string !empty
        if(i == s.length()){
            if(j+1 < p.length() && p.charAt(j+1) == '*'){
                return recur(s,p,i,j+2);
            }
            return false;
        }
        if(j+1 < p.length() && p.charAt(j+1) == '*'){ //p[j]+p[j+1] = a*
            boolean notComing = recur(s,p,i,j+2);
            boolean coming = (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) ? recur(s,p,i+1,j) : false;
            return notComing || coming;
        }

        if(p.charAt(j) == '.') return recur(s,p,i+1,j+1); // p[j] is a '.'

        return (s.charAt(i) == p.charAt(j)) ? recur(s,p,i+1,j+1) : false; //p[j] is normal char
    }


    public boolean memo(String s,String p,int i,int j,int[][] dp){
        if(i == s.length() && j == p.length()) return true; //Both the strings were able to match
        if(dp[i][j] != 0) return dp[i][j] == 1;
        if(j == p.length()) return false; //pattern is empty, but string !empty
        if(i == s.length()){
            if(j+1 < p.length() && p.charAt(j+1) == '*'){
                dp[i][j] = memo(s,p,i,j+2,dp) ? 1 : -1;
                return dp[i][j] == 1;
            }
            dp[i][j] = -1;
            return false;
        }
        if(j+1 < p.length() && p.charAt(j+1) == '*'){ //p[j]+p[j+1] = a*
            boolean notComing = memo(s,p,i,j+2,dp);
            boolean coming = (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) ? memo(s,p,i+1,j,dp) : false;
            dp[i][j] = notComing || coming ? 1 : -1;
            return dp[i][j] == 1;
        }

        if(p.charAt(j) == '.'){// p[j] is a '.'
            dp[i][j] = memo(s,p,i+1,j+1,dp) ? 1 : -1; 
            return dp[i][j] == 1;
        }

        dp[i][j] = ((s.charAt(i) == p.charAt(j)) ? memo(s,p,i+1,j+1,dp) : false) ? 1 : -1; //p[j] is normal char
        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        int[][] dp = new int[s.length() + 1][p.length() + 1 ];
        //dp[i][j] == 0 - untouched
        //dp[i][j] == -1 - result was false
        //dp[i][j] == 1 - result was true

        // return recur(s,p,0,0);
        return memo(s,p,0,0,dp);
    }
}