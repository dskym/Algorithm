class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        boolean[][] check = new boolean[m][n];
        for(int i=0;i<m*n;++i) {
            Pair<Integer, Integer> p = map.get(arr[i]);

            int x = p.getKey();
            int y = p.getValue();
            check[x][y] = true;

            boolean result = true;

            for(int j=0;j<m;++j) {
                if(check[j][y] == false) {
                    result = false;
                    break;
                }
            }

            if(result) {
                return i;
            }

            result = true;

            for(int j=0;j<n;++j) {
                if(check[x][j] == false) {
                    result = false;
                    break;
                }
            }

            if(result) {
                return i;
            }
        }

        return m*n;
    }
}
