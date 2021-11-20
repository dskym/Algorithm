class Solution {
public:
    int reinitializePermutation(int n) {
        int count = 0;
        
        vector<int> v;
        for(int i=0;i<n;++i)
            v.push_back(i);
        
        while(true) {
            vector<int> temp;
            for(int i=0;i<n;i+=2)
                temp.push_back(v[i]);
            for(int i=1;i<n;i+=2)
                temp.push_back(v[i]);
            
            v = temp;
            
            count++;
            
            bool flag = true;
            for(int i=0;i<n;++i) {
                if(v[i] != i) {
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                break;
        }
        
        return count;
    }
};
