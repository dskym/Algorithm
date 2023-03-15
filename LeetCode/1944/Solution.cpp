class Solution {
public:
    vector<int> canSeePersonsCount(vector<int>& heights) {
        stack<int> s;

        vector<int> ret(heights.size(), 0);

        for(int i=0;i<heights.size();++i) {
            while(!s.empty() && heights[s.top()] <= heights[i]) {
                ret[s.top()]++;
                s.pop();
            }
            if(!s.empty()) {
                ret[s.top()]++;
            }
            s.push(i);
        }

        return ret;
    }
};
