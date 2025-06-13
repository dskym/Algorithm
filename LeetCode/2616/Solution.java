class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums[nums.length-1]-nums[0];
        int result = nums[nums.length-1]-nums[0];
        while(start < end) {
            int mid = (start+end)/2;
            int count = solve(nums, mid);
            if(count >= p) {
                end=mid;
                result=Math.min(result,mid);
            } else {
                start=mid+1;
            }
        }
        return result;
    }

    private int solve(int[] nums, int base) {
        int index = 0;
        int result = 0;
        while(index < nums.length-1) {
            if(nums[index+1]-nums[index] <= base) {
                result++;
                index++;
            }
            index++;
        }
        return result;
    }
}
