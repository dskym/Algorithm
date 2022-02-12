class Solution {
public:
    bool check(string a, string b) {
        int count = 0;
        int n = a.size();
        for(int i=0;i<n;++i) {
            if(a[i] != b[i])
                count++;
            if(count > 1)
                return false;
        }
        if(count == 1)
            return true;
        return false;
    }
    
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        vector<vector<int>> graph(5001);
        vector<vector<bool>> visited(5001);
        int n = wordList.size();
        
        int endPos = -1;
        for(int i=0;i<n;++i) {
            if(wordList[i] == endWord) {
                endPos = i;
                break;
            }
        }
        
        if(endPos == -1)
            return 0;

        for(int i=0;i<n;++i) {
            for(int j=i+1;j<n;++j) {
                if(check(wordList[i], wordList[j])) {
                    graph[i].push_back(j);
                    graph[j].push_back(i);
                    visited[i].push_back(false);
                    visited[j].push_back(false);
                }
            }
        }
                
        int ret = 0;
        queue<pair<int, int>> q;
        for(int i=0;i<n;++i) {
            if(check(beginWord, wordList[i])) {
                q.push({i, 1});
            }
        }
        
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            
            if(t.first == endPos) {
                return t.second + 1;
            }
            
            for(int i=0;i<graph[t.first].size();++i) {
                if(visited[t.first][i] == false) {
                    q.push({graph[t.first][i], t.second + 1});
                    visited[t.first][i] = true;
                }
            }
        }
        
        return ret;
    }
};
