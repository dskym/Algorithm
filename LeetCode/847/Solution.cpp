class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        int result = 10000;

        int n = graph.size();
        
        int visited[12][5000];
        
        for(int i=0;i<12;++i)
            for(int j=0;j<5000;++j)
                visited[i][j] = false;
                
        int dest = (1 << n) - 1;

        //start, distance, visited
        queue<pair<pair<int, int>, int>> q;

        for(int i=0;i<n;++i) {
            q.push({{i, 0}, 1 << i});
            visited[i][1 << i] = true;
        }

        while(!q.empty()) {
            auto data = q.front();
            q.pop();
            
            int start = data.first.first;
            int dis = data.first.second;
            int status = data.second;
                                    
            if(status == dest) {
                result = dis;
                break;
            }
            
            for(int i=0;i<graph[start].size();++i) {
                int d = graph[start][i];
                int nv = status | 1 << d;
                
                if(visited[d][nv] == false) {
                    q.push({{d, dis + 1}, nv});
                    visited[d][nv] = true;
                }
            }
        }
        
        return result;
    }
};
