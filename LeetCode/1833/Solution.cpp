class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(costs.begin(), costs.end());
        
        int ret = 0;
        int sum = 0;
        for(int cost : costs) {
            if(sum + cost > coins)
                break;
            sum += cost;
            ret++;
        }
        return ret;
    }
};
