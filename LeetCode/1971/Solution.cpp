class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        map<int, vector<int>> m;
        for(vector<int> edge : edges) {
            if(m.find(edge[0]) == m.end()) {
                m[edge[0]] = {edge[1]};
            } else {
                m[edge[0]].push_back(edge[1]);
            }
            if(m.find(edge[1]) == m.end()) {
                m[edge[1]] = {edge[0]};
            } else {
                m[edge[1]].push_back(edge[0]);
            }
        }
        vector<int> visited(200001, false);
        queue<int> q;

        q.push(source);

        while(!q.empty()) {
            int t = q.front();
            q.pop();

            if(t == destination) {
                return true;
            }

            visited[t] = true;

            for(int i=0;i<m[t].size();++i) {
                if(!visited[m[t][i]]) {
                    q.push(m[t][i]);
                }
            }
        }
        return false;
    }
};
