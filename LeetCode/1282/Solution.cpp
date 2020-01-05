class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int, vector<int>> m;
        
        for(int i=0;i<groupSizes.size();++i)
            m[groupSizes[i]].push_back(i);
        
        vector<vector<int>> result;
        
        map<int, vector<int>>::iterator it;
        
        for(it=m.begin();it!=m.end();++it) {
            int size = it->first;
            
            for(int i=0;i<it->second.size() / size;++i) {
                vector<int> temp;
                
                for(int j=i*size;j<(i+1)*size;++j)
                    temp.push_back(it->second[j]);
                
                result.push_back(temp);
            }
        }
        
        return result;
    }
};
