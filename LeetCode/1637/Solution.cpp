class Solution {
public:
    int maxWidthOfVerticalArea(vector<vector<int>>& points) {
        sort(points.begin(), points.end());
        int ret = 0;
        for(int i=1;i<points.size();++i) {
            if(ret < points[i][0] - points[i-1][0])
                ret = points[i][0] - points[i-1][0];
        }
        return ret;
    }
};
