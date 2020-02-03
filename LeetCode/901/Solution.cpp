class StockSpanner {
public:
    int dp[100001];
    int arr[100001];
    int index;
    
    StockSpanner() {
        index = 0;
        
        for(int i=0;i<100001;++i)
            dp[i] = 1;
    }
    
    int next(int price) {
        int temp = index-1;
        arr[index] = price;

        while(temp >= 0) {
            if(arr[temp] <= arr[index]) {
                dp[index] += dp[temp];
                temp -= dp[temp];
            } else
                break;
        }
        
        return dp[index++];
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
