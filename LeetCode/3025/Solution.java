class Solution {
    public int numberOfPairs(int[][] points) {
        int result = 0;
        Arrays.sort(points, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        for(int i=0;i<points.length-1;++i) {
            for(int j=i+1;j<points.length;++j) {
                if(points[j][0] > points[i][0] || points[j][1] < points[i][1]) {
                    continue;
                }
                if(!isContains(points, i, j)) {
                    result++;
                }                
            }
        }
        return result;
    }

    private boolean isContains(int[][] points, int a, int b) {
        for(int i=a+1;i<b;++i) {
            if(points[i][0] <= points[a][0] && points[i][0] >= points[b][0] && points[i][1] >= points[a][1] && points[i][1] <= points[b][1]) {
                return true;
            }
        }
        return false;        
    }
}
