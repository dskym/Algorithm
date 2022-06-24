class Solution {
public:
    int maxCoins(vector<int>& piles) {
        sort(piles.begin(), piles.end());
        int count = piles.size()/3;
        int ret = 0;
        int index = piles.size()-1;
        for(int i=0;i<count;++i) {
            ret += piles[index-1];
            index-=2;
        }
        return ret;
    }
};
