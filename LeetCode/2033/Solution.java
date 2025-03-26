class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        int index = 0;
        int[] arr = new int[m*n];
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                arr[index++] = grid[i][j];
            }
        }

        Arrays.sort(arr);

        int temp = arr[m*n/2];

        int result = 0;
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] % x != temp % x) {
                    return -1;
                }
                result += Math.abs(temp-grid[i][j])/x;
            }
        }
        return result;
    }
}


