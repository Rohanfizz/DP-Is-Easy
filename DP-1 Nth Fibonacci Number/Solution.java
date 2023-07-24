class Solution {

  public int recur(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int fnm1 = recur(n - 1);
    int fnm2 = recur(n - 2);
    return fnm1 + fnm2;
  }

  public int memo(int n, int[] dp) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    //if answer is already calculated
    if (dp[n] != 0) return dp[n];

    int fnm1 = memo(n - 1, dp);
    int fnm2 = memo(n - 2, dp);
    //remember the result for this n
    dp[n] = fnm1 + fnm2;

    return fnm1 + fnm2;
  }

  public int tabulation(int n, int[] dp) {
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }

  public int tabTrick(int n, int[] dp) {
    for (int i = 0; i <= n; i++) {
      if (i == 0) {
        dp[i] = 0;
        continue;
      }
      if (i == 1) {
        dp[i] = 1;
        continue;
      }

      int fnm1 = dp[i - 1]; //memo(i-1,dp);
      int fnm2 = dp[i - 2]; //memo(i-2,dp);

      dp[i] = fnm1 + fnm2;
    }
    return dp[n];
  }

  public int spaceOpti(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    int fnm2 = 0;
    int fnm1 = 1;

    for (int i = 2; i <= n; i++) {
      int curr = fnm1 + fnm2;
      if (i == n) return curr;

      fnm2 = fnm1;
      fnm1 = curr;
    }
    return 0; //dummy
  }

  public int fib(int n) {
    // int[] dp = new int[n+1];
    // return recur(n);
    // return tabTrick(n,dp);
    return spaceOpti(n);
  }
}
