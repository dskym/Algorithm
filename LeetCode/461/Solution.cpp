class Solution {
public:
    int hammingDistance(int x, int y) {
        int temp = 1 << 30;

        int result = 0;
        
        for(int i=0;i<31;++i) {
            int a = x / temp;
            int b = y / temp;
            
            x = x - a * temp;
            y = y - b * temp;
            
            if(a != b)
                result++;
            
            temp = temp >> 1;
        }
        
        return result;
    }
};
