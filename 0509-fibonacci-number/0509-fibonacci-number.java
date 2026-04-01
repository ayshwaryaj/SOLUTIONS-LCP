class Solution {
    public int fib(int n) {
        if(n<=1)
            return n;
        int p2 =0;
        int p1 =1;
        int ans = 0;
        for(int s= 2; s<n; s++)
        {
            ans = p1+p2;
            p2=p1;
            p1=ans;
        }
        return ans;
    }
}