class Solution {
    public int fib(int n) {
        int dp[] =new int[n+1];
        if(n<=1)
            return n;
        dp[0] = 0;
        dp[1] = 1;
        for(int s = 2; s<=n; s++)
            dp[s] = dp[s-1]+dp[s-2];
        return dp[n];
    }
}