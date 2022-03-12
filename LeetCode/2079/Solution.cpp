class Solution {
public:
    int wateringPlants(vector<int>& plants, int capacity) {
        int ret = 0;
        int temp = capacity;
        for(int i=0;i<plants.size();++i) {
            if(plants[i] <= temp) {
                ret++;
                temp -= plants[i];
            } else {
                ret += 2 * i + 1;
                temp = capacity - plants[i];
            }
        }
        return ret;
    }
};
