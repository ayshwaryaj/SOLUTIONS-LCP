class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        int rowIndex = 0;
        while(rowIndex!=numRows)
        {
            long val = 1;
            for (int i = 0; i <= rowIndex; i++) {
                inner.add((int)val);
                val = val * (rowIndex - i) / (i + 1);
            }    
            
        outer.add(new ArrayList<>(inner)); 
        inner.clear(); 
        rowIndex++;
        }
        return outer;
    }
}