class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        vector<int> ret;
        vector<int> temp;
        for(int i=1;i<=m;++i) {
            temp.push_back(i);
        }
        for(int query : queries) {
            for(int i=0;i<temp.size();++i) {
                if(temp[i] == query) {
                    ret.push_back(i);
                    temp.erase(temp.begin() + i);
                    break;
                }
            }
            temp.insert(temp.begin(), query);
        }
        
        return ret;
    }
};
