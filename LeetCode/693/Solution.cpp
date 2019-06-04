class Solution {
public:
    bool hasAlternatingBits(int n) {
        bool result = true;
        
        int temp = n % 2;
        n /= 2;
        
        while(n) {
            int t = n % 2;
            
            if(temp == t) {
                result = false;
                break;
            }
            
            n /= 2;
            temp = t;
        }
        
        return result;
    }
};
