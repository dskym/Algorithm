class Solution {
public:    
    static bool compare(vector<int> a, vector<int> b) {
        return (a[0] < b[0]);
    }
    
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), compare);
        
        vector<vector<int>> ret;

        if(intervals.size() == 0)
            return ret;
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i=1;i<intervals.size();++i) {
            if(end >= intervals[i][0])
                end = max(end, intervals[i][1]);
            else {
                ret.push_back({start, end});
                
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        ret.push_back({start, end});

        return ret;
    }
};
