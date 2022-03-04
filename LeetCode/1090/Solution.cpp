class Solution {
public:
    int largestValsFromLabels(vector<int>& values, vector<int>& labels, int numWanted, int useLimit) {
        int n = values.size();
        
        vector<pair<int,int>> p;
        
        for(int i=0;i<n;++i) {
            p.push_back({values[i], labels[i]});
        }
        
        sort(p.begin(),p.end());
                
        int ret = 0;
        vector<int> remains(30000, useLimit);
        for(int i=n-1;i>=0;--i) {
            if(numWanted == 0)
                break;
            
            if(remains[p[i].second] > 0) {
                ret += p[i].first;
                remains[p[i].second]--;
                numWanted--;
            }
        }
        
        return ret;
    }
};
