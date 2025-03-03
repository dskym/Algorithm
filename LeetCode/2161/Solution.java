class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];
        int index = 0;
        for(int i=0;i<n;++i) {
            if(nums[i] < pivot) {
                result[index++] = nums[i];
            }
        }
        for(int i=0;i<n;++i) {
            if(nums[i] == pivot) {
                result[index++] = nums[i];
            }
        }
        for(int i=0;i<n;++i) {
            if(nums[i] > pivot) {
                result[index++] = nums[i];
            }
        }
        return result;
    }
}
