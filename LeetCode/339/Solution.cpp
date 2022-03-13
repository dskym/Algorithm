class Solution {
public:
    int solve(vector<NestedInteger>& nestedList, int depth) {
        int ret = 0;
        for(NestedInteger value : nestedList) {
            if(value.isInteger()) {
                ret += depth * value.getInteger();
            } else {
                ret += solve(value.getList(), depth + 1);
            }
        }
        return ret;
    }
    int depthSum(vector<NestedInteger>& nestedList) {
        return solve(nestedList, 1);
    }
};
