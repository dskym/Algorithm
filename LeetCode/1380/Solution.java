class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                int temp = matrix[i][j];
                boolean flag = true;

                for(int k=0;k<n;++k) {
                    if(temp < matrix[k][j]) {
                        flag = false;
                        break;
                    }
                }

                for(int k=0;k<m;++k) {
                    if(temp > matrix[i][k]) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
