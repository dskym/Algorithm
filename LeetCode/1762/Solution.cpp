class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        vector<int> temp;
        int maxHeight=0;
        for(int i=heights.size()-1;i>=0;--i) {
            if(heights[i] > maxHeight)
                temp.push_back(i);
            maxHeight = heights[i] > maxHeight ? heights[i] : maxHeight;
        }
        vector<int> ret;
        for(int i=temp.size()-1;i>=0;--i)
            ret.push_back(temp[i]);
        return ret;
    }
};
