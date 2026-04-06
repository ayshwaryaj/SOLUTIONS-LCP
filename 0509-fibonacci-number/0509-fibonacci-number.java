class Solution {
    public int fib(int n) {
        int dp[] = new int [n+1];
        if(n<=1)
            return n;
        p2 = 0;
        p1 = 1;
        int ans;
        for(int s=2; s<=n; s++)
            {
                ans = p1+p2;
                p2 = p1;
                p1 = ans;
            }
        return ans;
    }
}