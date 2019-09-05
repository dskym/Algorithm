class Solution {
public:
    int fourSumCount(vector<int>& A, vector<int>& B, vector<int>& C, vector<int>& D) {
        map<int, int> m;
        
        for(int a : A)
            for(int b : B)
                m[a+b]+=1;

        int ret = 0;
        
        for(int c : C)
            for(int d : D)
                ret += m[-(c+d)];
        
        return ret;
    }
};
