class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        int cnt[2001];
        
        for(int i=0;i<2001;++i)
            cnt[i] = 0;
        
        for(int temp : arr)
            cnt[temp+1000]++;
        
        map<int, int> m;
        
        for(int i=0;i<=2000;++i) {
            if(cnt[i] == 0)
                continue;
            
            if(m.count(cnt[i]) == 0)
                m[cnt[i]] = i;
            else
                return false;
        }
        
        return true;
    }
};
