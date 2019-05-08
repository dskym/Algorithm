class Solution {
public:
    int binaryGap(int N) {
        int result = 0;
        int count = 0;
        int arr[32];
        int index = 0;
        
        for(int i=0;i<32;++i)
            arr[i] = 0;
        
        while(N) {
            arr[index++] = N % 2;
            N /= 2;
        }
        
        for(int i=index-1;i>=0;--i) {
            if(arr[i]) {
                result = max(result, count);
                count = 1;
            } else {
                count++;
            }
        }
        
        return result;
    }
};
