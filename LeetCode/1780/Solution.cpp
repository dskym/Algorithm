class Solution {
public:
    bool checkPowersOfThree(int n) {
        int a[15];
        int temp = 1;
        for(int i=0;i<15;++i) {
            a[i] = temp;
            temp *= 3;
        }
        for(int i=0;i<15;++i) {
            if(solve(n-a[i], a, i+1))
                return true;
        }
        return false;
    }
    bool solve(int n, int* arr, int index) {
        if(n == 0)
            return true;
        
        for(int i=index;i<15;++i) {
            if(solve(n-arr[i], arr, i+1))
                return true;
        }
        
        return false;
    }
};
