class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        vector<int> v1, v2;
        int n = s1.size();
        
        for(int i=0;i<n;++i) {
            v1.push_back(s1[i] - 'a');
            v2.push_back(s2[i] - 'a');
        }
        
        sort(v1.begin(), v1.end());
        sort(v2.begin(), v2.end());

        if(v1[0] >= v2[0]) {
            bool flag1 = true;
            for(int i=1;i<n;++i) {
                if(v1[i] < v2[i]) {
                    flag1 = false;
                    break;
                }
            }
            if(flag1)
                return true;
        }
        
        if(v1[0] <= v2[0]) {
            bool flag2 = true;
            for(int i=1;i<n;++i) {
                if(v1[i] > v2[i]) {
                    flag2 = false;
                    break;
                }
            }
            if(flag2)
                return true;
        }
        
        return false;
    }
};
