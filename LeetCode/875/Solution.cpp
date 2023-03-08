class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int left = 1, right = 1000000000;

        while(left <= right) {
            int mid = (left + right) / 2;
            unsigned long long int count = 0;

            for(int i=0;i<piles.size();++i) {
                count += (piles[i] / mid);
                count += (piles[i] % mid == 0) ? 0 : 1;
            }

            if(count > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
};
