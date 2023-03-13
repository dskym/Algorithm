class Solution {
public:
    int minJumps(vector<int>& arr) {
        bool visited[50001];
        queue<pair<int, int>> q;
        map<int, vector<int>> m;

        for(int i=0;i<arr.size();++i) {
            m[arr[i]].push_back(i);
        }

        for(int i=0;i<50001;++i) {
            visited[i] = false;
        }

        q.push({0, 0});
        visited[0] = true;

        while(!q.empty()) {
            auto t = q.front();
            q.pop();

            int index = t.first;
            int count = t.second;

            if(index == arr.size()-1) {
                return count;
            }

            if(index >= 1 && visited[index-1] == false) {
                q.push({index-1, count+1});
                visited[index-1] = true;
            }

            if(index + 1 < arr.size() && visited[index+1] == false) {
                q.push({index+1, count+1});
                visited[index+1] = true;
            }

            for(int i=0;i<m[arr[index]].size();++i) {
                if(m[arr[index]][i] != index && visited[m[arr[index]][i]] == false) {
                    q.push({m[arr[index]][i], count+1});
                    visited[m[arr[index]][i]] = true;
                }
            }
            m[arr[index]].clear();
        }
        return 0;
    }
};
