class Solution {
public:
    int findComplement(int num) {
        int temp = num;
        int count = 0;
        
        while(num) {
            num /= 2;
            count++;
        }
        
        unsigned long long int result = 1;
        
        result = (1 << count);
        
        return result - temp - 1;
    }
};
