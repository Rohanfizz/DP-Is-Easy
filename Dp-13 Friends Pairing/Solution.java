//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public long recur(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        long ansNm1 = recur(n-1);
        long ansNm2 = recur(n-2);
        return ansNm1 + (n-1)*ansNm2;
        // return recur(n-1) + (n-1)*recur(n-2);
    }
    public long memo(int n,long[] dp){
        long md = 1000000007;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) return dp[n];
        long ansNm1 = memo(n-1,dp);
        long ansNm2 = memo(n-2,dp);
        return dp[n] = (ansNm1 + ((n-1)*ansNm2)%md)%md;
        // return recur(n-1) + (n-1)*recur(n-2);
    }
    
    long tabulation(int N,long[] dp){
       long md = 1000000007;
       for(int n = 1;n<=N;n++){
            if(n == 1){
                dp[n] = 1;
                continue;
            }
            if(n == 2){
                dp[n] = 2;
                continue;
            }
            
            long ansNm1 = dp[n-1];//memo(n-1,dp);
            long ansNm2 = dp[n-2];//memo(n-2,dp);
            dp[n] = (ansNm1 + ((n-1)*ansNm2)%md)%md;
       }
       return dp[N];
    }
    
    public long countFriendsPairings(int n) { 
       //code here
       long md = 1000000007;
       long[] dp = new long[n+1];
       Arrays.fill(dp,-1);
        //   return recur(n);
        // return memo(n,dp)%md;
        return tabulation(n,dp)%md;
    }
}    












 