class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int m = queries.length;

        int start = 0;
        int end = m;
        
        if(!solve(nums, queries, end)) {
            return -1;
        }
        
        while(start <= end) {
            int mid = (start + end) / 2;

            if(solve(nums, queries, mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return start;
    }

    private boolean solve(int[] nums, int[][] queries, int k) {
        int n = nums.length;

        int[] diff = new int[n+1];
        for(int i=0;i<k;++i) {
            diff[queries[i][0]] += queries[i][2];
            diff[queries[i][1]+1] -= queries[i][2];
        }

        int temp = 0;
        for(int i=0;i<n;++i) {
            temp += diff[i];
            if(temp < nums[i]) {
                return false;
            }
        }
        return true;
    }
}

