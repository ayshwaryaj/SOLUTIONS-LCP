/*class Solution {
    public int maximalSquare(char[][] matrix) {
        int ms= 0;
        int [][]m = new int [matrix.length][matrix[0].length]; 
        for(int i= 0; i< matrix.length; i++)
        {
            for(int j=0; j< matrix[0].length; j++)
            {
                if(matrix[i][j] == '1')
                {
                    if(i==0 || j==0)
                        m[i][j] = 1;
                    else
                    {
                        m[i][j] = 1 + Math.min(Math.min(
                        m[i-1][j],
                        m[i][j-1]),
                        m[i-1][j-1]
                    );
                    }
                }
                ms = Math.max(ms, m[i][j]);
                
            }
        }
        System.out.print(ms);
        return ms * ms;
    }
}*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int ms = 0;

        // normalize input
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (char)(matrix[i][j] - '0');
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == 1) {

                    if (i > 0 && j > 0) {
                        int T = matrix[i-1][j];
                        int TL = matrix[i-1][j-1];
                        int L = matrix[i][j-1];

                        int currentSide = 1 + Math.min(Math.min(T, TL), L);
                        matrix[i][j] = (char) currentSide;

                        ms = Math.max(ms, currentSide);
                    } else {
                        ms = Math.max(ms, 1);
                    }
                }
            }
        }

        return ms * ms;
    }
}

/*class Solution {
    public int maximalSquare(char[][] matrix) {
        int ms= 0;
        int [][]m = new int [matrix.length][matrix[0].length]; 
        for(int i= 0; i< matrix.length; i++)
        {
            for(int j=0; j< matrix[0].length; j++)
            {
                if(matrix[i][j] == '1')
                {
                    if(i==0 || j==0)
                        m[i][j] = 1;
                    else
                    {
                        m[i][j] = 1 + Math.min(Math.min(
                        m[i-1][j],
                        m[i][j-1]),
                        m[i-1][j-1]
                    );
                    }
                }
                ms = Math.max(ms, m[i][j]);
                
            }
        }
        System.out.print(ms);
        return ms * ms;
    }
}*/