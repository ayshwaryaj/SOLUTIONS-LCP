class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0)
            return -1;
        int [][] directions = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        grid[0][0] =1;
        while(!queue.isEmpty())
        {
            int[] first = queue.remove();
            int row =first[0], col=first[1], steps = first[2];
            if(row == grid.length-1 && col == grid[0].length-1)
                return steps;
            for(int[]direction : directions)
            {
                int newRow = row+direction[0];
                int newCol =col+direction[1];
                if(newRow>=0 && newRow<grid.length &&
                   newCol >= 0 && newCol<grid[0].length &&
                   grid[newRow][newCol]==0)
                   {
                    grid[newRow][newCol]=1;
                    queue.add(new int[]{newRow, newCol, steps+1});
                   }
            }
        }
        return -1;
        }
    }