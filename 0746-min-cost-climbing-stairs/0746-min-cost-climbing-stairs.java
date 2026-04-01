class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int p2 = 0;
        int p1 = 0;
        int ans = 0;
        for(int s= 2; s<=n; s++)
        {
            int S1= cost[s-1]+p1;
            int S2= cost[s-2]+p2;
            ans = Math.min(S1, S2);
            p2=p1;
            p1=ans;
        }
        return ans;
    }
}