class Solution {
public:
    int repeatedNTimes(vector<int>& A) {
        int count[10000];
        
        for(int i=0;i<10000;++i)
            count[i] = 0;
        
        for(int num : A) {
            count[num]++;
            
            if(count[num] == A.size() / 2)
                return num;
        }
        
        return -1;
    }
};
