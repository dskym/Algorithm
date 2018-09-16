class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> result;
        
        result.push_back(0);
        
        int base = 1;
        
        for(int i=1;i<=num;++i) {            
            if(i == base * 2)
                base *= 2;
            
            result.push_back(result[i % base] + 1);
        }
        
        return result;
    }
};
