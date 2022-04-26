class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        priority_queue<pair<int, pair<int, int>>> pq;
        vector<bool> visited(1001, false);

        int start = 0;
        for(int i=1;i<points.size();++i) {
            pq.push({-abs(points[i][0] - points[0][0]) - abs(points[i][1] - points[0][1]), {0, i}});
        }
        visited[start] = true;
        
        int result = 0;
        
        while(!pq.empty()) {
            auto t = pq.top();
            pq.pop();

            int node = t.second.second;
            
            if(visited[node])
                continue;
            
            result += -t.first;
            visited[node] = true;
            for(int i=0;i<points.size();++i) {
                if(visited[i] == false)
                    pq.push({-abs(points[i][0] - points[node][0]) - abs(points[i][1] - points[node][1]), {node, i}});
            }
        }
        
        return result;
    }
};
