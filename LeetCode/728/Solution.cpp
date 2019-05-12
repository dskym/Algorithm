class Solution {
public:
    bool check(int num) {
        int temp = num;
        
        while(temp) {
            int t = temp % 10;
            
            if(t == 0 || num % t != 0)
                return false;
            
            temp /= 10;
        }
        
        return true;
    }
    
    vector<int> selfDividingNumbers(int left, int right) {
        vector<int> result;
        
        for(int i=left;i<=right;++i) {
            if(check(i)) {
                result.push_back(i);
            }
        }
        
        return result;
    }
};
