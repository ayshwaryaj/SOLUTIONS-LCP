class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else
        {
            int p2 =1;
            int p1 =2;
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
}