/*class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        for(int time[]:times)
        {
            int u = time[0]-1;
            int v = time[1]-1;
            int w = time[2];
            adj.get(u).add(new int[]{v,w});
        }
        int minTime[] = dijkstra(k-1, n, adj);
        int res = Integer.MIN_VALUE;
        for(int time: minTime)
            res = Math.max(res,time);
        return(res == Integer.MAX_VALUE)?-1:res;
    }
    public int[] dijkstra(int s, int n, ArrayList<ArrayList<int[]>> adj)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        /*(new Comparator<int[]>(){
            public int compare(int a[], int b[])
            {
                return a[1]-b[1];
            }
        });*/
/*        int time[]=new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[s] = 0;
        pq.offer(new int[]{s,0});
        while(!pq.isEmpty()){
            int pair[]=pq.poll();
            int u =pair[0];
            int w = pair[1];
            if(w>time[u])
                continue;
            for(int neighbor[]:adj.get(u))
            {
                int v = neighbor[0];
                int t = neighbor[1];
                if(time[u]+t<time[v])
                {
                    time[v]=time[u]+t;
                    pq.offer(new int[]{v,time[v]});
                }
            }
        }
        return time;
    }
}*/
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> graph = new HashMap<>();
    for(int[] time: times)
    {
        int src = time[0], tar = time[1], weight=time[2];
        if(!graph.containsKey(src))
            graph.put(src,new LinkedList<int[]>());
        graph.get(src).add(new int[] {tar, weight});
    }
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1]-b[1]);
    Set<Integer> visited = new HashSet<>();
    minHeap.add(new int[]{k,0});
    int res = 0;
    while(!minHeap.isEmpty())
    {
        int[] top = minHeap.poll();
        int src = top[0], srcWeight = top[1];
        if(visited.contains(src))
            continue;
        res=srcWeight;
        visited.add(src);
        if(!graph.containsKey(src))
            continue;
        for(int[] edge:graph.get(src))
        {
            int tar = edge[0], tarweight = edge[1];
            minHeap.add(new int[]{tar, srcWeight+tarweight});
        }
    }
    return visited.size()==n?res:-1;
    }
}