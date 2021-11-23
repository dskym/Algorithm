class Solution {
public:
    int solve(vector<int> fibo, int k) {
        if(k == 0)
            return 0;
        
        int count = 0;
        
        for(int i=fibo.size()-1;i>=0;--i) {
            if(k - fibo[i] >= 0) {
                return solve(fibo, k-fibo[i]) + 1;
            }
        }
        
        return count;
    }
    int findMinFibonacciNumbers(int k) {
        vector<int> fibo;
        fibo.push_back(1);
        fibo.push_back(1);
        for(int i=2;;++i) {
            int temp = fibo[i-1] + fibo[i-2];
            
            if(temp > 1000000000)
                break;
            
            fibo.push_back(temp);
        }

        return solve(fibo, k);
    }
};
