class Solution {
public:
    vector<int> countPoints(vector<vector<int>>& points, vector<vector<int>>& queries) {
        vector<int> ret;
        
        for(vector<int> query : queries) {
            int count = 0;
            for(vector<int> point : points) { 
                if((point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
                    count++;
                }
            }
            ret.push_back(count);
        }
        
        return ret;
    }
};