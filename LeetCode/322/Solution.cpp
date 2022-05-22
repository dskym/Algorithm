class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        sort(coins.begin(), coins.end());
        
        vector<int> result(10001, 1000000);
        result[0] = 0;
        
        for(int i=1;i<=amount;++i) {
            for(int j=0;j<coins.size();++j) {
                if(i - coins[j] >= 0)
                    result[i] = min(result[i], 1 + result[i - coins[j]]);
                else
                    break;
            }
        }
        
        return result[amount] == 1000000 ? -1 : result[amount];
    }
};

