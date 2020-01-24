class Solution {
public:
    string removeDuplicates(string s, int k) {
        stack<pair<char, int>> storage;
        
        for(char c : s) {
            if(storage.empty()) {
                storage.push({c, 1});
                continue;
            }
            
            auto t = storage.top();
            
            if(t.first == c) {
                if(t.second+1 == k) {
                    for(int i=0;i<t.second;++i)
                        storage.pop();
                } else
                    storage.push({c, t.second+1});
            } else
                storage.push({c, 1});
        }
        
        string ret = "";

        while(!storage.empty()) {
            auto temp = storage.top();
            storage.pop();
            
            ret = temp.first + ret;
        }
        
        return ret;
    }
};
