class Solution {
public:
    map<int, vector<int>> tree;
    vector<int> killProcess(vector<int>& pid, vector<int>& ppid, int kill) {
        vector<int> ret;
        for(int i=0;i<pid.size();++i) {
            tree[ppid[i]].push_back(pid[i]);
        }
        queue<int> q;
        q.push(kill);
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            ret.push_back(t);
            
            for(int i=0;i<tree[t].size();++i) {
                q.push(tree[t][i]);
            }
        }
        return ret;
    }
};
