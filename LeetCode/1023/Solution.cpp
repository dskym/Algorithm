class Solution {
public:
    bool check(string query, string pattern, int indexA, int indexB) {
        if(pattern.size() == indexB) {
            for(int i=indexA;i<query.size();++i)
                if(query[i] >= 'A' && query[i] <= 'Z')
                    return false;
            
            return true;
        }
        
        if(query.size() <= indexA || (query[indexA] >= 'A' && query[indexA] <= 'Z' && pattern[indexB] >= 'A' && pattern[indexB] <= 'Z' && query[indexA] != pattern[indexB]))
            return false;
        
        if(query[indexA] == pattern[indexB])
            return check(query, pattern, indexA+1, indexB+1);
        else
            return check(query, pattern, indexA+1, indexB);
        
        return false;
    }
    
    vector<bool> camelMatch(vector<string>& queries, string pattern) {
        vector<bool> ret;
        
        for(string query : queries) {
            ret.push_back(check(query, pattern, 0, 0));
        }
        
        return ret;
    }
};
