class Solution {

    public boolean recur(String s,String p,int i ,int j){
        
        if(i == s.length() && j== p.length()) return true;//both empty

        if(i != s.length() && j == p.length()) return false; // s isnt empty, but pattern is no more

        if(i == s.length() && j != p.length()){

            if(p.charAt(j) != '*') return false;

            return recur(s,p,i,j+1); //star will act  as empty string
        }

        if(p.charAt(j)  == '?'){
            return recur(s,p,i+1,j+1);
        }else if(p.charAt(j) == '*'){
            boolean emptyStar = recur(s,p,i,j+1);
            boolean consume = recur(s,p,i+1,j);
            return emptyStar || consume;
        }
        ///if im a normal character, i have only one  option which is to match
        if(s.charAt(i) != p.charAt(j)) return false;
        return recur(s,p,i+1,j+1);
    }

    public boolean memo(String s,String p,int i ,int j,int[][] dp){
        // dp[i][j] = -1 = false
        // dp[i][j] = 0 = i have not calculated the answer for i,j
        // dp[i][j] = 1 = true
        
        if(i == s.length() && j== p.length()) return true;//both empty

        if(i != s.length() && j == p.length()) return false; // s isnt empty, but pattern is no more

        if(dp[i][j] != 0){//Recall
            return dp[i][j] == 1;
        }

        if(i == s.length() && j != p.length()){

            if(p.charAt(j) != '*') return false;

            dp[i][j] = memo(s,p,i,j+1,dp) ? 1 : -1; //star will act  as empty string
            return dp[i][j] == 1;
        }

        if(p.charAt(j)  == '?'){
            dp[i][j] = memo(s,p,i+1,j+1,dp) ? 1 : -1;
            return dp[i][j] == 1;
        }else if(p.charAt(j) == '*'){
            boolean emptyStar = memo(s,p,i,j+1,dp);
            boolean consume = memo(s,p,i+1,j,dp);
            dp[i][j] = emptyStar || consume ? 1 : -1; 
            return dp[i][j] == 1;
        }
        ///if im a normal character, i have only one  option which is to match
        if(s.charAt(i) != p.charAt(j)) return false;
        dp[i][j] = memo(s,p,i+1,j+1,dp) ? 1 : -1;
        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) {
        // return recur(s,p,0,0);
        int[][] dp = new int[s.length()+1][p.length()+1];
        return memo(s,p,0,0,dp);
    }
}