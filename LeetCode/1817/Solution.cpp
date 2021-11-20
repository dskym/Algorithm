class Solution {
public:
    vector<int> findingUsersActiveMinutes(vector<vector<int>>& logs, int k) {
        vector<int> ret(k,0);
        
        map<int, set<int>> m;
        
        for(vector<int> log : logs) {
            m[log[0]].insert(log[1]);
        }
        
        for(auto it = m.begin();it != m.end();it++) {
            if(it->second.size() > 0) {
                ret[it->second.size()-1]++;
            }
        }
        
        return ret;
    }
};
