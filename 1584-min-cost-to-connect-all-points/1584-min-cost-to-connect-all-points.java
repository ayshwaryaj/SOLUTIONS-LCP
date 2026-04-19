class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean [] visited = new boolean[n];
        PriorityQueue<int[]> minheap =new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        minheap.add(new int[]{0,0,0});
        int e = 0;
        int ans = 0;
        while(e<=(n-1))
        {
            int [] at =minheap.poll();
            if(visited[at[1]]) continue;
            ans +=at[2];
            e +=1;
            visited[at[1]]=true;
            for(int to=0; to<n; to++)
            {
                if(!visited[to])
                {
                    int dx = Math.abs(points[at[1]][0]-points[to][0]);
                    int dy = Math.abs(points[at[1]][1]-points[to][1]);
                    int dist =dx+dy;
                    minheap.add(new int[]{at[1], to,dist});
                }
            }
        }
        return ans;
    }
}