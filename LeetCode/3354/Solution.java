class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int result = 0;
        for(int i=0;i<n;++i) {
            if(nums[i] != 0) {
                continue;
            }
            if(move(nums, i, 1)) {
                result++;
            }
            if(move(nums, i, -1)) {
                result++;
            }
        }
        return result;
    }

    private boolean move(int[] nums, int pos, int direct) {
        int n = nums.length;
        int[] temp = nums.clone();

        while(pos >= 0 && pos < n) {
            if(temp[pos] > 0) {
                temp[pos]--;
                direct *= -1;
            }           
            pos = pos + direct;
        }

        for(int i=0;i<n;++i) {
            if(temp[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
