
//User function Template for Java

class Solution{
    
    static boolean recur(int[] arr,int i,int sum){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(i == arr.length) return false;
        
        boolean come = recur(arr,i+1,sum-arr[i]);
        boolean dont = recur(arr,i+1,sum);
        return come || dont;
    }
    static boolean memo(int[] arr,int i,int sum,int[][] dp){
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(i == arr.length) return false;
        if(dp[i][sum] != 0) return (dp[i][sum] == 1);
            
        boolean come = memo(arr,i+1,sum-arr[i],dp);
        boolean dont = memo(arr,i+1,sum,dp);
        dp[i][sum] = come || dont ? 1 : -1;
        return come || dont;
    }
    
    static boolean tabulation(int[] arr,int sum)    {
        int N = arr.length;
        boolean[][] dp = new boolean[N+1][sum+1];
        
        for(int i = 0;i<=N;i++){
            dp[i][0] = true;
        }
        
        for(int i = 1;i<=N;i++){
            for(int j = 1;j<=sum;j++){
                //do not come
                boolean dont = dp[i-1][j];
                //i want to come
                int me = arr[i-1];
                boolean coming = j-me >=0 ? dp[i-1][j-me] : false;
                
                dp[i][j] = coming || dont;
            }
        }
        return dp[N][sum];
    }
    
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        // int[][] dp = new int[N+1][sum+1];
        // return memo(arr,0,sum,dp);
        return tabulation(arr,sum);
    }
}


