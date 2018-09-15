class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size() == 0)
            return 0;
        
        int min = prices[0];
        int result = 0;
        
        for(int i=1;i<prices.size();++i) {
            if(min > prices[i])
                min = prices[i];
            else            
                result = max(result, prices[i] - min);
        }
        
        return result;
    }
};
