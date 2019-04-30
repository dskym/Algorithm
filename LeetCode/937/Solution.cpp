struct NODE {
    int dis;
    int index;
};

int compare(NODE a, NODE b) {
    return (a.dis < b.dis);
}

class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int K) {
        vector<NODE> v;
        
        for(int i=0;i<points.size();++i)
            v.push_back({points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        
        sort(v.begin(), v.end(), compare);
        
        vector<vector<int>> ret;

        for(int i=0;i<K;++i)
            ret.push_back(points[v[i].index]);
        
        return ret;
    }
};
