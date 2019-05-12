class Solution {
public:
    int bitwiseComplement(int N) {
        if(N == 0)
            return 1;

        int result = 0;
        int base = 1;
        
        while(N) {
            result += (1 - (N % 2)) * base;
            base *= 2;
            N /= 2;
        }
        
        return result;
    }
};
