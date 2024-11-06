class Solution {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        for(int i=0;i<n;++i) {
            count[i] = getCount(nums[i]);
        }

        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        int temp1 = nums[0];
        int temp2 = nums[0];
        for(int i=1;i<n;++i) {
            if(count[i-1] != count[i]) {
                small.add(temp1);
                big.add(temp2);
                temp1 = nums[i];
                temp2 = nums[i];
            }

            if(temp1 > nums[i]) {
                temp1 = nums[i];
            }
            if(temp2 < nums[i]) {
                temp2 = nums[i];
            }
        }
        small.add(temp1);
        big.add(temp2);

        for(int i=0;i<big.size()-1;++i) {
            if(big.get(i) > small.get(i+1)) {
                return false;
            }
        }

        return true;
    }
    
    private int getCount(int num) {
        int result = 0;
        while(num != 0) {
            if(num % 2 == 1) {
                result++;
            }
            num /= 2;
        }
        return result;
    }
}
