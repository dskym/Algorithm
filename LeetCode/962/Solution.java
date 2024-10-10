class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0;i<n;++i) {
            if (stack.isEmpty() || nums[stack.peek()]>nums[i]) {
                stack.push(i);
            }
        }
        
        int result = 0;
        for (int j=n-1;j>=0;--j) {
            while (!stack.isEmpty() && nums[stack.peek()]<=nums[j]) {
                result = Math.max(result, j-stack.pop());
            }
        }        
        return result;
    }
}
