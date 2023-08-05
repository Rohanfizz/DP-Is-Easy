//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static long recur(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        long vertical = recur(n-1);
        long horizontal = recur(n-2);
        
        return vertical + horizontal;
    }

    static long memo(int n,long[] dp){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] != -1) return dp[n];
        long md = 1000000007;
        
        long vertical = memo(n-1,dp);
        long horizontal = memo(n-2,dp);
        
        return dp[n] = (vertical + horizontal)%md;
    }
    static long tabulation(int N,long[] dp){
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
            
            
            long vertical = dp[n-1];//memo(n-1,dp);
            long horizontal = dp[n-2];//memo(n-2,dp);
            
            dp[n] = (vertical + horizontal)%md;
        }
        return dp[N];
    }
    
    static long spaceOpti(int N){
        if(N == 1) return 1;
        if(N == 2) return 2;
        long fnm2 = 1;
        long fnm1 = 2;
        long md = 1000000007;
        
        for(int i = 3;i<=N;i++){
            long curr = (fnm2 + fnm1)%md;
            if(i == N) return curr;
            
            fnm2 = fnm1;
            fnm1 = curr;
        }
        return -1; //dummy
    }
    
    static Long numberOfWays(int N) {
        // code here
        // long[] dp = new long[N+1];
        long md = 1000000007;
        // Arrays.fill(dp,-1);
        // return recur(N);
        // return memo(N,dp)%md;
        // return tabulation(N,dp)%md;
        return spaceOpti(N)%md;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
};