class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0)
            return false;
        
        int temp = x;
        long long int base = 1;
        
        while(temp) {
            temp /= 10;
            base *= 10;
        }
        
        base /= 10;
        
        while(x) {
            if(x / base == x % 10) {
                x = x - base * (x / base);
                x /= 10;
                base /= 100;
            } else
                return false;
        }
        
        return true;
    }
};
