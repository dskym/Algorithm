class Solution {
public:
    bool static compare(vector<int>& a, vector<int>& b) {
        return a[1] > b[1];
    }
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        sort(boxTypes.begin(), boxTypes.end(), compare);
        int result = 0;
        for(int i=0;i<boxTypes.size();++i) {
            if(truckSize >= boxTypes[i][0]) {
                result += boxTypes[i][1] * boxTypes[i][0];
                truckSize -= boxTypes[i][0];
            } else {
                result += boxTypes[i][1] * truckSize;
                break;
            }
        }
        return result;
    }
};
