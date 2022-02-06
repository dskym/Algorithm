class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> ret(nums.size(), 0);
        
        int small = 0, eq = 0;
        
        for(int n : nums) {
            if(pivot > n)
                small++;
            else if(pivot == n)
                eq++;
        }
        
        int index=0;
        int eqBase = small;
        int bigBase = small+eq;
        for(int n : nums) {
            if(n < pivot) {
                ret[index++] = n;
            } else if(n == pivot) {
                ret[eqBase++] = n;
            } else {
                ret[bigBase++] = n;
            }
        }
        
        return ret;
    }
};
